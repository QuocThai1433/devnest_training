package com.devnest.user.repository;

import com.devnest.user.model.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepsitory extends JpaRepository<TeacherEntity, Long> {
}
