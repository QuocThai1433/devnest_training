package com.devnest.database.user.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_student_account")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentAccountEntity extends AbstractEntity<Long> {

    @OneToOne
    @JoinColumn(name = "student_id", nullable = false)
    StudentEntity studentEntity;

    @Column(name = "login_name", length = 50, nullable = false)
    String loginName;

    @Column(name = "password", length = 255, nullable = false)
    String password;

    @Column(name = "is_active", nullable = false)
    Boolean isActive = true;

    @Column(name = "description", columnDefinition = "TEXT")
    String description;
}
