package com.devnest.course.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devnest.course.dto.StudentDTO;
import com.devnest.course.mapper.StudentMapper;
import com.devnest.course.model.StudentEntity;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/course/api/test/students")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class StudentController {
    StudentMapper studentMapper;
    @PostMapping
    public StudentEntity createStudent(@RequestBody StudentDTO dto) {               
        StudentEntity entity = studentMapper.toEntity(dto);
        return entity;
    }
}
