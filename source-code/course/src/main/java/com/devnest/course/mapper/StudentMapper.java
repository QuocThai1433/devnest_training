package com.devnest.course.mapper;

import org.mapstruct.Mapper;

import com.devnest.course.dto.StudentDTO;
import com.devnest.course.model.StudentEntity;
@Mapper(componentModel = "spring")
public interface StudentMapper extends EntityMapper<StudentDTO, StudentEntity>{
}
