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
@Table(name = "tbl_level")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LevelEntity extends AbstractEntity<Long> {

    @Column(name = "code", nullable = false, length = 255)
    String code; 

    @Column(name = "name", nullable = false, length = 255)
    String name; 

    @Column(name = "description", columnDefinition = "TEXT")
    String description;
}
