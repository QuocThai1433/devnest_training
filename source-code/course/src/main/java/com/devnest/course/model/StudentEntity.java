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
@Table(name = "tbl_student")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentEntity extends AbstractEntity<Long> {
	
    @Column(name = "date_birth", nullable = false)
    Date dateBirth;

    @Column(name = "state", length = 50, nullable = false)
    String state;

    @Column(name = "city", length = 100, nullable = false)
    String city;

    @Column(name = "zip_code", length = 20, nullable = false)
    String zipCode;

    @Column(name = "street", length = 200, nullable = false)
    String street;

    @Column(name = "first_name", length = 50, nullable = false)
    String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    String lastName;

    @Column(name = "email", length = 100, nullable = false)
    String email;

    @Column(name = "phone", length = 20, nullable = false)
    String phone;

    @Column(name = "description", columnDefinition = "TEXT")
    String description;
    
    @OneToOne(mappedBy = "studentEntity", cascade = CascadeType.ALL)
    StudentAccountEntity studentAccountEntity;
	
}
