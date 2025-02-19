package com.devnest.course.mapper;

import org.mapstruct.Mapper;

import com.devnest.course.dto.CategoryDTO;
import com.devnest.course.model.CategoryEntity;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends EntityMapper <CategoryDTO, CategoryEntity>{

}
