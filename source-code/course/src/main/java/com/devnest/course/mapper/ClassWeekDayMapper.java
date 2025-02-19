package com.devnest.course.mapper;

import org.mapstruct.Mapper;

import com.devnest.course.dto.ClassWeekDayDTO;
import com.devnest.course.model.ClassWeekDayEntity;

@Mapper(componentModel = "spring")
public interface ClassWeekDayMapper extends EntityMapper <ClassWeekDayDTO, ClassWeekDayEntity>{

}
