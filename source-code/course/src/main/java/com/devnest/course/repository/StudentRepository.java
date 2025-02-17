package com.devnest.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devnest.course.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
