package com.devnest.course.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "tbl_class_weekday")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClassWeekDayEntity extends AbstractEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    ClassEntity classEntity;

    @ManyToOne
    @JoinColumn(name = "weekday_id", nullable = false)
    WeekDayEntity weekDayEntity;
}
