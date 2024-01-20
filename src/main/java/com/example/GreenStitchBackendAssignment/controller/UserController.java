package com.example.GreenStitchBackendAssignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.GreenStitchBackendAssignment.entity.User;
import com.example.GreenStitchBackendAssignment.model.UserModel;
import com.example.GreenStitchBackendAssignment.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody UserModel userModel) {
        return new ResponseEntity<User>(userService.createUser(userModel), HttpStatus.CREATED);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello()
    {
        return new ResponseEntity<String>("Hello from GreenStitch", HttpStatus.OK);
    }
    
}
