package com.nsi.fsbs.services.web.impl;

import com.nsi.common.dto.UserRegistrationDTO;
import com.nsi.common.model.UserRole;
import com.nsi.fsbs.exception.UserAlreadyExistException;
import com.nsi.fsbs.repository.UserRepository;
import com.nsi.common.model.jpa.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    public User registerNewUserAccount(UserRegistrationDTO userDTO) throws UserAlreadyExistException {
        log.info("------------------>: {}", emailAlreadyExist(userDTO.getEmail()));
        if(emailAlreadyExist(userDTO.getEmail()))
            throw new UserAlreadyExistException("Email address already exist");

        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setSex(userDTO.getSex());
        user.setGender(userDTO.getGender());
        user.setPictureUrl(userDTO.getPictureUrl());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setDateOfBirth(LocalDate.now());
        user.setCountryCode("NG");
        user.setUserId(1L);
//        user.setRoles(List.of(UserRole.USER));

        return userRepository.save(user);
    }

    public boolean emailAlreadyExist(String email){
        return userRepository.findByEmail(email) != null;
    }
}
