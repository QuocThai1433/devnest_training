package com.devnest.course.mapper;

import org.mapstruct.Mapper;

import com.devnest.course.dto.StaffAccountDTO;
import com.devnest.course.model.StaffAccountEntity;

@Mapper(componentModel = "spring")
public interface StaffAccountMapper extends EntityMapper<StaffAccountDTO, StaffAccountEntity>{
}