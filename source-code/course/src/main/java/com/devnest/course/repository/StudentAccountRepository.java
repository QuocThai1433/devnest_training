package com.devnest.course.repository;

import com.devnest.course.model.StudentAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentAccountRepository extends JpaRepository<StudentAccountEntity, Long> {
    Optional<StudentAccountEntity> findByLoginName(String loginName);
}
