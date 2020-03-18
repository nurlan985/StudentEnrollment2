package edu.miu.cs.cs544.group1.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import edu.miu.cs.cs544.group1.service.IAuthenticationFacade;

@Component
public class AuthenticationFacade implements IAuthenticationFacade {
 
    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
