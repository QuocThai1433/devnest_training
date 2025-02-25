package com.devnest.course.repository;

import com.devnest.course.model.TeacherAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherAccountRepository extends JpaRepository<TeacherAccountEntity, Long> {
    Optional<TeacherAccountEntity> findByLoginName(String loginName);
}
