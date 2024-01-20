package com.example.GreenStitchBackendAssignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.GreenStitchBackendAssignment.entity.LoginDetails;
import com.example.GreenStitchBackendAssignment.entity.User;
import com.example.GreenStitchBackendAssignment.model.UserModel;
import com.example.GreenStitchBackendAssignment.repository.LoginDetailsRepository;
import com.example.GreenStitchBackendAssignment.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoginDetailsRepository loginDetailsRepository;

    public User createUser(UserModel userModel)
    {
        User user = new User(userModel);

        LoginDetails loginDetails = new LoginDetails(userModel);
        loginDetailsRepository.save(loginDetails);
        System.err.println("Login details created");
        return userRepository.save(user);
    }

    public List<User> getAllUsers()
    {
        return(List<User>) userRepository.findAll();
    }
}
