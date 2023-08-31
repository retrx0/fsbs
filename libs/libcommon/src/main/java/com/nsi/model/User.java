package com.nsi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;

@Data
@AllArgsConstructor
public class User {

    String userId;
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    ArrayList<UserRole> roles;
    String pictureUrl;
    String countryCode;
    boolean gender;
    LocalDate dateOfBirth;

}
