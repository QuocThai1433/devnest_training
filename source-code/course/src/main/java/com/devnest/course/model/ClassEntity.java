package com.devnest.course.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
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
@Table(name = "tbl_class")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClassEntity extends AbstractEntity<Long>{
	@Column(name = "name", nullable = false, length = 255)
    String name;

    @Column(name = "start_date", nullable = false)
    LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    LocalDateTime endDate;

    @Column(name = "price", nullable = false)
    Double price;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    TeacherEntity teacher; 
    
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    CourseEntity course; 

    @Column(name = "description", columnDefinition = "TEXT")
    String description;
}