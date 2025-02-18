package com.devnest.course.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@Table(name = "tbl_teacher_account")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeacherAccountEntity extends AbstractEntity<Long> {
	
	@OneToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    TeacherEntity teacherEntity;

    @Column(name = "login_name", length = 50, nullable = false)
    String loginName;

    @Column(name = "password", length = 255, nullable = false)
    String password;

    @Column(name = "is_active", nullable = false)
    Boolean isActive = true;

    @Column(name = "description", columnDefinition = "TEXT")
    String description;

    @Column(name = "created_by", length = 50, nullable = false)
    String createdBy;

    @Column(name = "created_date", nullable = false)
    Date createdDate;

    @Column(name = "updated_by", length = 50)
    String updatedBy;

    @Column(name = "updated_date")
    Date updatedDate;

}
