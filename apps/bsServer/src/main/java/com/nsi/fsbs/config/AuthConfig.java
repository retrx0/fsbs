package com.nsi.fsbs.config;

import com.nsi.fsbs.services.auth.impl.UserAuthService;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthConfig {

    private final UserAuthService userAuthService;

    public AuthConfig(UserAuthService userAuthService) {
        this.userAuthService = userAuthService;
    }

}
