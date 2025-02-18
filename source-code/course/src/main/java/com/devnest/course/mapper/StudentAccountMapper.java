package com.devnest.course.mapper;

import org.mapstruct.Mapper;

import com.devnest.course.dto.StudentAccountDTO;
import com.devnest.course.model.StudentAccountEntity;

@Mapper(componentModel = "spring")
public interface StudentAccountMapper extends EntityMapper<StudentAccountDTO, StudentAccountEntity> {
}