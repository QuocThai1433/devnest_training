package com.devnest.user.mapper;

import com.devnest.database.user.model.StudentEntity;
import com.devnest.user.dto.StudentDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper extends EntityMapper<StudentDTO, StudentEntity> {
}
