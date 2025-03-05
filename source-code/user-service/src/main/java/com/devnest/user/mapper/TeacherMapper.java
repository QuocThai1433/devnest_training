package com.devnest.user.mapper;

import com.devnest.database.dto.TeacherDTO;
import com.devnest.user.model.TeacherEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeacherMapper extends EntityMapper<TeacherDTO, TeacherEntity> {
}
