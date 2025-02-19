package com.devnest.course.dto;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeacherDTO {
	Long id;

    @NotBlank(message = "First name is required")
    String firstName;

    @NotBlank(message = "Last name is required")
    String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{10,20}$", message = "Invalid phone number format")
    @Size(max = 20, message = "Phone number cannot exceed 20 characters")
    String phone;

    @Size(max = 255, message = "Image URL cannot exceed 255 characters")
    String imageUrl;

    @Size(max = 1000, message = "Description cannot exceed 1000 characters")
    String description;

    String createdBy;
    Date createdDate;
    String updatedBy;
    Date updatedDate;

//    TeacherAccountDTO teacherAccount;
}
