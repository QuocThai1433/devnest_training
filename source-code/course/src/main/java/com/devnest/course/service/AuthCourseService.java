package com.devnest.course.service;

import com.devnest.course.dto.*;
import com.devnest.course.dto.request.RegisterRequest;
import com.devnest.course.dto.response.AuthCourseResponseDTO;
import com.devnest.course.exception.UsernameNotFoundException;
import com.devnest.course.mapper.*;
import com.devnest.course.model.*;
import com.devnest.course.repository.*;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthCourseService {
    StaffAccountRepository staffAccountRepository;
    StaffRepository staffRepository;
    StudentAccountRepository studentAccountRepository;
    StudentRepository studentRepository;
    TeacherAccountRepository teacherAccountRepository;
    TeacherRepository teacherRepository;

    StaffMapper staffMapper;
    StaffAccountMapper staffAccountMapper;
    TeacherMapper teacherMapper;
    TeacherAccountMapper teacherAccountMapper;
    StudentMapper studentMapper;
    StudentAccountMapper studentAccountMapper;

    public AuthCourseResponseDTO findUserByUsernameAndRole(String username, String role) {
        return switch (role.toLowerCase()) {
            case "staff" -> staffAccountRepository.findByLoginName(username)
                    .map(entity -> new AuthCourseResponseDTO(entity.getLoginName(), entity.getPassword(), role))
                    .orElseThrow(() -> new UsernameNotFoundException("Staff account không tồn tại"));
            case "student" -> studentAccountRepository.findByLoginName(username)
                    .map(entity -> new AuthCourseResponseDTO(entity.getLoginName(), entity.getPassword(), role))
                    .orElseThrow(() -> new UsernameNotFoundException("Student account không tồn tại"));
            case "teacher" -> teacherAccountRepository.findByLoginName(username)
                    .map(entity -> new AuthCourseResponseDTO(entity.getLoginName(), entity.getPassword(), role))
                    .orElseThrow(() -> new UsernameNotFoundException("Teacher account không tồn tại"));
            default -> throw new IllegalArgumentException("Role không hợp lệ: " + role);
        };
    }

    @Transactional
    public String createAccount(RegisterRequest request) {
        if (isUsernameExists(request.getUsername())) {
            throw new IllegalArgumentException("Username đã tồn tại");
        }
        if ("student".equalsIgnoreCase(request.getRole()) && (request.getEmail() == null || request.getPhone() == null)) {
            throw new IllegalArgumentException("Email và Phone không được để trống cho vai trò Student");
        }

        switch (request.getRole().toLowerCase()) {
            case "staff" -> createStaffAccount(request);
            case "student" -> createStudentAccount(request);
            case "teacher" -> createTeacherAccount(request);
            default -> throw new IllegalArgumentException("Role không hợp lệ: " + request.getRole());
        }

        return request.getUsername();
    }

    private void createStaffAccount(RegisterRequest request) {
        StaffEntity staffEntity = staffMapper.toEntity((StaffDTO) toDTO(request, "staff"));
        staffEntity = staffRepository.save(staffEntity);

        StaffAccountEntity staffAccount = staffAccountMapper.toEntity((StaffAccountDTO) toDTO(request, "staffaccount"));
        staffAccount.setStaffEntity(staffEntity);
        staffAccountRepository.save(staffAccount);

        staffEntity.setStaffAccount(staffAccount);
        staffRepository.save(staffEntity);
    }

    private void createStudentAccount(RegisterRequest request) {
        StudentEntity studentEntity = studentMapper.toEntity((StudentDTO) toDTO(request, "student"));
        studentEntity = studentRepository.save(studentEntity);

        StudentAccountEntity studentAccount = studentAccountMapper.toEntity((StudentAccountDTO) toDTO(request, "studentaccount"));
        studentAccount.setStudentEntity(studentEntity);
        studentAccountRepository.save(studentAccount);

        studentEntity.setStudentAccountEntity(studentAccount);
        studentRepository.save(studentEntity);
    }

    private void createTeacherAccount(RegisterRequest request) {
        TeacherEntity teacherEntity = teacherMapper.toEntity((TeacherDTO) toDTO(request, "teacher"));
        teacherEntity = teacherRepository.save(teacherEntity);

        TeacherAccountEntity teacherAccount = teacherAccountMapper.toEntity((TeacherAccountDTO) toDTO(request, "teacheraccount"));
        teacherAccount.setTeacherEntity(teacherEntity);
        teacherAccountRepository.save(teacherAccount);

        teacherEntity.setTeacherAccount(teacherAccount);
        teacherRepository.save(teacherEntity);
    }

    private boolean isUsernameExists(String username) {
        return staffAccountRepository.findByLoginName(username).isPresent() ||
                studentAccountRepository.findByLoginName(username).isPresent() ||
                teacherAccountRepository.findByLoginName(username).isPresent();
    }

    @SuppressWarnings("unchecked")
    private <T> T toDTO(RegisterRequest request, String type) {
        switch (type.toLowerCase()) {
            case "staff":
                StaffDTO staffDTO = new StaffDTO();
                staffDTO.setFirstName(request.getFirstName());
                staffDTO.setLastName(request.getLastName());
                staffDTO.setEmail(request.getEmail());
                staffDTO.setPhone(request.getPhone());
                staffDTO.setDescription(request.getDescription());
                staffDTO.setPosition(request.getPosition());
                staffDTO.setCreatedBy("system");
                return (T) staffDTO;

            case "staffaccount":
                StaffAccountDTO staffAccountDTO = new StaffAccountDTO();
                staffAccountDTO.setLoginName(request.getUsername());
                staffAccountDTO.setPassword(request.getPassword());
                staffAccountDTO.setIsActive(true);
                staffAccountDTO.setDescription(request.getDescription());
                staffAccountDTO.setCreatedBy("system"); // Thêm giá trị mặc định
                return (T) staffAccountDTO;

            case "student":
                StudentDTO studentDTO = new StudentDTO();
                studentDTO.setFirstName(request.getFirstName());
                studentDTO.setLastName(request.getLastName());
                studentDTO.setEmail(request.getEmail());
                studentDTO.setPhone(request.getPhone());
                studentDTO.setDescription(request.getDescription());
                studentDTO.setDateBirth(request.getDateBirth());
                studentDTO.setState(request.getState());
                studentDTO.setCity(request.getCity());
                studentDTO.setZipCode(request.getZipCode());
                studentDTO.setStreet(request.getStreet());
                studentDTO.setCreatedBy("system");
                return (T) studentDTO;

            case "studentaccount":
                StudentAccountDTO studentAccountDTO = new StudentAccountDTO();
                studentAccountDTO.setLoginName(request.getUsername());
                studentAccountDTO.setPassword(request.getPassword());
                studentAccountDTO.setIsActive(true);
                studentAccountDTO.setDescription(request.getDescription());
                studentAccountDTO.setCreatedBy("system"); // Thêm giá trị mặc định
                return (T) studentAccountDTO;

            case "teacher":
                TeacherDTO teacherDTO = new TeacherDTO();
                teacherDTO.setFirstName(request.getFirstName());
                teacherDTO.setLastName(request.getLastName());
                teacherDTO.setEmail(request.getEmail());
                teacherDTO.setPhone(request.getPhone());
                teacherDTO.setDescription(request.getDescription());
                teacherDTO.setImageUrl(request.getImageUrl());
                teacherDTO.setCreatedBy("system");
                return (T) teacherDTO;

            case "teacheraccount":
                TeacherAccountDTO teacherAccountDTO = new TeacherAccountDTO();
                teacherAccountDTO.setLoginName(request.getUsername());
                teacherAccountDTO.setPassword(request.getPassword());
                teacherAccountDTO.setIsActive(true);
                teacherAccountDTO.setDescription(request.getDescription());
                teacherAccountDTO.setCreatedBy("system"); // Thêm giá trị mặc định
                return (T) teacherAccountDTO;

            default:
                throw new IllegalArgumentException("Loại DTO không hợp lệ: " + type);
        }
    }
}