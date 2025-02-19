package com.devnest.course.mapper;

import org.mapstruct.Mapper;

import com.devnest.course.dto.CourseDTO;
import com.devnest.course.model.CourseEntity;

@Mapper(componentModel = "spring")
public interface CourseMapper extends EntityMapper <CourseDTO, CourseEntity>{

}
