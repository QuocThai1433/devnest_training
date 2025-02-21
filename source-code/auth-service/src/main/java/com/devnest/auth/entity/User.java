package com.devnest.auth.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_user")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @OneToOne
    @JoinColumn(name = "role_id", nullable = false)
    Role role;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, unique = true)
    String username;

    @Column(nullable = false)
    String password;

    @Column(nullable = false)
    String name;
}
