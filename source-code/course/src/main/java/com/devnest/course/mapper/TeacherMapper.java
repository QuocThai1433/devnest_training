package com.devnest.course.mapper;

import org.mapstruct.Mapper;

import com.devnest.course.dto.TeacherDTO;
import com.devnest.course.model.TeacherEntity;

@Mapper(componentModel = "spring")
public interface TeacherMapper extends EntityMapper<TeacherDTO, TeacherEntity>{
}