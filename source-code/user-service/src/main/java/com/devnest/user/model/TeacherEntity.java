package com.devnest.user.model;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_teacher")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeacherEntity extends AbstractEntity<Long> {

    @Column(name = "first_name", length = 50, nullable = false)
    String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    String lastName;

    @Column(name = "email", length = 100, nullable = false)
    String email;

    @Column(name = "phone", length = 20, nullable = false)
    String phone;

    @Column(name = "image_url", length = 255)
    String imageUrl;

    @Column(name = "description", columnDefinition = "TEXT")
    String description;


    @OneToOne(mappedBy = "teacherEntity", cascade = CascadeType.ALL)

    TeacherAccountEntity teacherAccount;
}

