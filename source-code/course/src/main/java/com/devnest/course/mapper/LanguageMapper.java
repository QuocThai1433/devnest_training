package com.devnest.course.mapper;

import org.mapstruct.Mapper;

import com.devnest.course.dto.LanguageDTO;
import com.devnest.course.model.LanguageEntity;

@Mapper(componentModel = "spring")
public interface LanguageMapper extends EntityMapper<LanguageDTO, LanguageEntity>{

}
