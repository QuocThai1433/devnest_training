package com.devnest.course.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@Table(name = "tbl_student")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student extends AbstractEntity<Long> {
	
}
