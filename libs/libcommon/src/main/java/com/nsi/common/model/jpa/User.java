package com.nsi.common.model.jpa;

import com.nsi.common.model.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "user", schema = "public")
@Getter
@Setter
@ToString
public class User implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long userId;
    @NotNull
    String firstName;
    @NotNull
    String lastName;
    @NotNull
    String email;
    @NotNull
    String phoneNumber;
    @NotNull
    @ToString.Exclude
    List<UserRole> roles;
    String pictureUrl;
    @NotNull
    String countryCode;
    String gender;
    @NotNull
    LocalDate dateOfBirth;
    @NotNull
    String password;
    @NotNull
    char sex;

}
