package com.nsi.fsbs.services.web.impl;

import com.nsi.dto.UserRegistrationDTO;
import com.nsi.fsbs.exception.UserAlreadyExistException;
import com.nsi.fsbs.repository.UserRepository;
import com.nsi.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    public User registerNewUserAccount(UserRegistrationDTO userDTO) throws UserAlreadyExistException {
        if(emailAlreadyExist(userDTO.getEmail()))
            throw new UserAlreadyExistException("Email address already exist");

        UserRegistrationDTO user = new UserRegistrationDTO();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
//        user.setRoles(Arrays.asList("ROLE_USER"));

//        return userRepository.save(user);

        return null;
    }

    public boolean emailAlreadyExist(String email){
        return userRepository.findByEmail(email) != null;
    }
}
