package com.devnest.course.mapper;

import org.mapstruct.Mapper;

import com.devnest.course.dto.LevelDTO;
import com.devnest.course.model.LevelEntity;

@Mapper(componentModel = "spring")
public interface LevelMapper extends EntityMapper <LevelDTO, LevelEntity>{

}