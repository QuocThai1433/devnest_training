package com.devnest.course.mapper;

import org.mapstruct.Mapper;

import com.devnest.course.dto.StaffDTO;
import com.devnest.course.model.StaffEntity;

@Mapper(componentModel = "spring")
public interface StaffMapper extends EntityMapper<StaffDTO, StaffEntity> {
}