package com.nsi.dto;

import com.nsi.model.User;
import com.nsi.model.UserRole;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
public class UserDTO extends User {

    public UserDTO(String userId, String firstName, String lastName, String email, String phoneNumber, ArrayList<UserRole> roles, String pictureUrl, String countryCode, boolean gender, LocalDate dateOfBirth, boolean isDeleted, String deletedBy, LocalDateTime lastLogin, LocalDateTime lastModified) {
        super(userId, firstName, lastName, email, phoneNumber, roles, pictureUrl, countryCode, gender, dateOfBirth);
        this.isDeleted = isDeleted;
        this.deletedBy = deletedBy;
        this.lastLogin = lastLogin;
        this.lastModified = lastModified;
    }

    boolean isDeleted;
    String deletedBy;
    LocalDateTime lastLogin;
    LocalDateTime lastModified;

}
