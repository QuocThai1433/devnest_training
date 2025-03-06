package com.devnest.database.user.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


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
