package com.devnest.course.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_course")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourseEntity extends AbstractEntity<Long> {

    @Column(name = "lessons", nullable = false)
    int lessons; 

    @Column(name = "term", nullable = false, length = 255)
    String term; 

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id", nullable = false)
    LanguageEntity language;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id", nullable = false)
    LevelEntity level;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    CategoryEntity category; 

    @Column(name = "description", columnDefinition = "TEXT")
    String description; 
}
