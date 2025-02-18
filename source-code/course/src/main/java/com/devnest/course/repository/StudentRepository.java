package com.devnest.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devnest.course.model.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long>{

}
