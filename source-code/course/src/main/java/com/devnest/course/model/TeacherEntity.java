package com.devnest.course.model;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@Table(name = "tbl_teacher")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeacherEntity extends AbstractEntity<Long>{
	
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

    @Column(name = "created_by", length = 50, nullable = false)
    String createdBy;

    @Column(name = "created_date", nullable = false)
    Date createdDate;

    @Column(name = "updated_by", length = 50)
    String updatedBy;

    @Column(name = "updated_date")
    Date updatedDate;

    @OneToOne(mappedBy = "teacherEntity", cascade = CascadeType.ALL)
    TeacherAccountEntity teacherAccount;

}
