package com.devnest.course.model;


import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@MappedSuperclass
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class AbstractEntity<T> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    T id;

    @Column(name = "created_by", length = 255)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    String createdBy;
    
    @Column(name = "created_date", length = 255)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    Date createdDate;

    @Column(name = "updated_by", length = 255)
    String updatedBy;
    
    @Column(name = "updated_date", length = 255)
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    Date updatedDate;
}
