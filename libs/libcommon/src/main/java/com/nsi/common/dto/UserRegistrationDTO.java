package com.nsi.common.dto;

import com.nsi.common.annotations.PasswordMatches;
import com.nsi.common.annotations.ValidEmail;
import com.nsi.common.model.UserRole;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@PasswordMatches
public class UserRegistrationDTO {
    Long userId;
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
    List<UserRole> roles;
    String pictureUrl;
    String countryCode;
    String gender;
    char sex;
    LocalDate dateOfBirth;
    boolean isDeleted;
    String deletedBy;
    LocalDateTime lastLogin;
    LocalDateTime lastModified;
}
