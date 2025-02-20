package com.devnest.course.mapper;

import org.mapstruct.Mapper;

import com.devnest.course.dto.TeacherAccountDTO;
import com.devnest.course.model.TeacherAccountEntity;

@Mapper(componentModel = "spring")
public interface TeacherAccountMapper extends EntityMapper<TeacherAccountDTO, TeacherAccountEntity>{
}