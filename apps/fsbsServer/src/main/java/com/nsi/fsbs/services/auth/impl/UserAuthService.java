package com.nsi.fsbs.services.auth.impl;

import com.nsi.fsbs.exception.UserNameNotFoundException;
import com.nsi.fsbs.repository.UserRepository;
import com.nsi.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService {

    private final UserRepository userRepository;

    public UserAuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void loadUserByUsername(String email) throws UserNameNotFoundException {
        User user = userRepository.findByEmail(email);
        if(user == null) throw new UserNameNotFoundException("Username not found!");

        // checks
        boolean enabled = true;
        boolean accountExpired = true;
        boolean credentialsExpired = true;
        boolean accountBlocked = true;


    }
}
