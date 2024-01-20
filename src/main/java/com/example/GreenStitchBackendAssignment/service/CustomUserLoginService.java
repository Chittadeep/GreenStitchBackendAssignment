package com.example.GreenStitchBackendAssignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.GreenStitchBackendAssignment.entity.LoginDetails;
import com.example.GreenStitchBackendAssignment.repository.LoginDetailsRepository;

@Component
public class CustomUserLoginService implements UserDetailsService {
    @Autowired
    private LoginDetailsRepository loginDetailsRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginDetails loginDetails = loginDetailsRepository.getLoginDetailsByUserName(username);
        System.out.println(username);
        System.out.println(loginDetails.getUserName());
        return org.springframework.security.core.userdetails.User.builder().username(loginDetails.getUserName())
        .password(passwordEncoder.encode(loginDetails.getPassword())).authorities("USER").build();
    }
    
}
