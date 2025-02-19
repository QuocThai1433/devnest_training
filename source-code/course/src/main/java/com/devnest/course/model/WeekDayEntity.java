package com.devnest.course.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@Entity
@Table(name = "tbl_weekday")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WeekDayEntity extends AbstractEntity<Long> {

    @Column(name = "name", nullable = false, length = 255)
    String name;

    @Column(name = "hours", nullable = false, length = 255)
    String hours;

    @Column(name = "description", length = 255)
    String description; 
}
