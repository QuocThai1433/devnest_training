package com.devnest.course.dto;


import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Data
public class StudentDTO {
	Long id;

    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    Date dateBirth;

    @NotBlank(message = "State is required")
    String state;

    @NotBlank(message = "City is required")
    @Size(max = 100, message = "City cannot exceed 100 characters")
    String city;

    @NotBlank(message = "Zip code is required")
    @Pattern(regexp = "^[0-9]{5,20}$", message = "Invalid zip code format")
    @Size(max = 20, message = "Zip code cannot exceed 20 characters")
    String zipCode;

    @NotBlank(message = "Street is required")
    String street;

    @NotBlank(message = "First name is required")
    String firstName;

    @NotBlank(message = "Last name is required")
    String lastName;
    
    String createdBy;
    Date createdDate;
    String updatedBy;
    Date updatedDate;

}