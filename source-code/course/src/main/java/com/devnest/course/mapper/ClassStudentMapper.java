package com.devnest.course.mapper;

import org.mapstruct.Mapper;

import com.devnest.course.dto.ClassStudentDTO;
import com.devnest.course.model.ClassStudentEntity;

@Mapper(componentModel = "spring")
public interface ClassStudentMapper extends EntityMapper <ClassStudentDTO, ClassStudentEntity>{

}