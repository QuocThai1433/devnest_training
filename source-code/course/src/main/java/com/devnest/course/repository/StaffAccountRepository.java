package com.devnest.course.repository;

import com.devnest.course.model.StaffAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffAccountRepository extends JpaRepository<StaffAccountEntity, Long> {
    Optional<StaffAccountEntity> findByLoginName(String loginName);
}
