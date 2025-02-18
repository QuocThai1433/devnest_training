package com.devnest.course.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class StaffAccountDTO {
	Long id;

    StaffDTO staff;

    @NotBlank(message = "Login name is required")
    String loginName;

    @NotBlank(message = "Password is required")
    String password;

    @NotNull(message = "Active status is required")
    Boolean isActive = true;

    @Size(max = 1000, message = "Description cannot exceed 1000 characters")
    String description;

}