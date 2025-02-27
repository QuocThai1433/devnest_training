package com.devnest.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devnest.course.model.StudentEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long>{

}
