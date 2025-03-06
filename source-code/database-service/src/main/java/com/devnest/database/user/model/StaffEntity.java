package com.devnest.database.user.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_staff")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StaffEntity extends AbstractEntity<Long>{

    @Column(name = "first_name", nullable = false)
    String firstName;

    @Column(name = "last_name", nullable = false)
    String lastName;

    @Column(name = "email", nullable = false)
    String email;

    @Column(name = "phone", nullable = false)
    String phone;

    @Column(name = "position", nullable = false)
    String position;

    @Column(name = "description", columnDefinition = "TEXT")
    String description;

    @OneToOne(mappedBy = "staffEntity", cascade = CascadeType.ALL)
    StaffAccountEntity staffAccount;

}