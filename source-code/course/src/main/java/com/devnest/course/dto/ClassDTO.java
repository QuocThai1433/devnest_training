package com.devnest.course.dto;

import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClassDTO {
	Long id;
    String name;
    LocalDateTime startDate;
    LocalDateTime endDate;
    Double price;
    Long teacherId;
    Long courseId;
    String description;
}
