package com.devnest.course.mapper;

import org.mapstruct.Mapper;

import com.devnest.course.dto.ClassDTO;
import com.devnest.course.model.ClassEntity;

@Mapper(componentModel = "spring")
public interface ClassMapper extends EntityMapper <ClassDTO, ClassEntity>{
	
}
