package com.devnest.user.mapper;

import com.devnest.user.dto.StudentDTO;
import com.devnest.user.model.StaffEntity;
import com.devnest.database.dto.StaffDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface StaffMapper extends EntityMapper<StaffDTO, StaffEntity> {
}

