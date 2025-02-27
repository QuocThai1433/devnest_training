package com.devnest.course.dto.request;

import java.util.Date;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    // Thông tin tài khoản chung
    private String username;
    private String password;
    private String role;

    // Thông tin chung
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String description;

    // Thông tin dành cho Student
    private Date dateBirth;
    private String state;
    private String city;
    private String zipCode;
    private String street;

    // Thông tin dành cho Teacher
    private String imageUrl;

    // Thông tin dành cho Staff
    private String position;
}