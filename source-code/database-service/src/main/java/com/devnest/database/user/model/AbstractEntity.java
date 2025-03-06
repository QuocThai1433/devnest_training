package com.devnest.database.user.model;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

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
    String createdBy = "SYSTEM";

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
