package com.nsi.dto;

import com.nsi.annotations.PasswordMatches;
import com.nsi.annotations.ValidEmail;
import com.nsi.model.UserRole;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@PasswordMatches
public class UserRegistrationDTO {
    String userId;
    @NotNull @NotEmpty
    String firstName;
    @NotNull @NotEmpty
    String lastName;
    @NotNull @NotEmpty @ValidEmail
    String email;
    @NotNull @NotEmpty
    String password;
    String matchingPassword;
    String phoneNumber;
    UserRole role;
    String pictureUrl;
    String countryCode;
    boolean gender;
    LocalDate dateOfBirth;
    boolean isDeleted;
    String deletedBy;
    LocalDateTime lastLogin;
    LocalDateTime lastModified;
}
