package com.devnest.user.mapper;

import com.devnest.user.dto.StudentDTO;
import com.devnest.database.dto.StaffDTO;
import org.mapstruct.Mapper;

import com.devnest.database.user.model.StaffEntity;


@Mapper(componentModel = "spring")
public interface StaffMapper extends EntityMapper<StaffDTO, StaffEntity> {
}


