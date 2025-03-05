package com.devnest.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import  com.devnest.database.dto.StaffDTO;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StaffAccountDTO {
    Long id;

    StaffDTO  staff;

    @NotBlank(message = "Login name is required")
    String loginName;

    @NotBlank(message = "Password is required")
    String password;

    @NotNull(message = "Active status is required")
    Boolean isActive = true;

    @Size(max = 1000, message = "Description cannot exceed 1000 characters")
    String description;
    String createdBy;
    Date createdDate;
    String updatedBy;
    Date updatedDate;

}