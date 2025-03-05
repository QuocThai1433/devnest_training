package com.devnest.user.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;
import com.devnest.database.model.AbstractEntity;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
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
}
