package com.devnest.course.mapper;

import org.mapstruct.Mapper;

import com.devnest.course.dto.WeekDayDTO;
import com.devnest.course.model.WeekDayEntity;

@Mapper(componentModel = "spring")
public interface WeekDayMapper extends EntityMapper <WeekDayDTO, WeekDayEntity>{

}
