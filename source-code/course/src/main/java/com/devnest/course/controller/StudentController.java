//package com.devnest.course.controller;
//
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.devnest.course.dto.StudentDTO;
//import com.devnest.course.mapper.StudentMapper;
//import com.devnest.course.model.StudentEntity;
//
//import lombok.AccessLevel;
//import lombok.RequiredArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@RestController
//@RequestMapping("/api/test/students")
//@RequiredArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
//public class StudentController {
//	
//    StudentMapper studentMapper;
//    
//	@PostMapping()
//    public String testStudent(@RequestBody StudentDTO studentDTO) {
////		System.out.println("Start testing StudentDTO: " + studentDTO);
//        
//
//        StudentEntity entity = studentMapper.toStudentEntityMapper(studentDTO);
//        System.out.println("Converted to Entity: {}" + entity);
////
////        StudentDTO convertedDto = studentMapper.toStudentEntityMapper(entity);
////        System.out.println("Converted back to DTO: {}" + convertedDto);
//
//        return "";
//        }
//}