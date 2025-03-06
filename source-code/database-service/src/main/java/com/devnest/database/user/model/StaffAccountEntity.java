package com.devnest.database.user.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_staff_account")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StaffAccountEntity extends AbstractEntity<Long>{

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id", nullable = false)
    StaffEntity staffEntity;

    @Column(name = "login_name", nullable = false)
    String loginName;

    @Column(name = "password", nullable = false)
    String password;

    @Column(name = "is_active", nullable = false)
    Boolean isActive = true;

    @Column(name = "description", columnDefinition = "TEXT")
    String description;

}
