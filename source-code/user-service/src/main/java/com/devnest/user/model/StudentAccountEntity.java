package com.devnest.user.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_student_account")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentAccountEntity extends com.devnest.database.model.AbstractEntity<Long> {

    @OneToOne
    @JoinColumn(name = "student_id", nullable = false)
    com.devnest.database.model.StudentEntity studentEntity;

    @Column(name = "login_name", length = 50, nullable = false)
    String loginName;

    @Column(name = "password", length = 255, nullable = false)
    String password;

    @Column(name = "is_active", nullable = false)
    Boolean isActive = true;

    @Column(name = "description", columnDefinition = "TEXT")
    String description;
}
