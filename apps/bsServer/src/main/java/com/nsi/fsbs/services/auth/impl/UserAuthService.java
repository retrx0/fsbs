package com.nsi.fsbs.services.auth.impl;

import com.nsi.common.model.UserRole;
import com.nsi.common.model.jpa.UserMetadata;
import com.nsi.fsbs.exception.UserNameNotFoundException;
import com.nsi.fsbs.repository.UserMetadataRepository;
import com.nsi.fsbs.repository.UserRepository;
import com.nsi.common.model.jpa.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserAuthService {

    private final UserRepository userRepository;
    private final UserMetadataRepository userMetadataRepository;

    public UserAuthService(UserRepository userRepository, UserMetadataRepository userMetadataRepository) {
        this.userRepository = userRepository;
        this.userMetadataRepository = userMetadataRepository;
    }

    public UserDetails loadUserByUsername(String email) throws UserNameNotFoundException {

        // checks
        boolean isActive = false;
        boolean accountExpired = false;
        boolean credentialsExpired = false;
        boolean accountBlocked = false;

        try {
            User user = userRepository.findByEmail(email);
            UserMetadata userMetadata = null;
            if(user == null) throw new UserNameNotFoundException("Username not found!");
            else {
                userMetadata = userMetadataRepository.getById(user.getUserId());
            }

            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(),
                    user.getPassword().toLowerCase(),
                    userMetadata.isActive(),
                    accountExpired,
                    userMetadata.isCredExpired(),
                    userMetadata.isBlocked(),
                    getAuthorities(user.getRoles()));
        } catch (Exception e){

        }

        return null;
    }

    private static List<GrantedAuthority> getAuthorities (List<UserRole> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (UserRole role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.toString()));
        }
        return authorities;
    }
}
