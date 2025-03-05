package com.devnest.user.mapper;

import com.devnest.user.dto.StudentDTO;
import com.devnest.user.model.StudentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper extends EntityMapper<StudentDTO, StudentEntity> {
}
