package com.example.GreenStitchBackendAssignment.controller;

import java.security.Principal;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RestController;

import com.example.GreenStitchBackendAssignment.config.JwtService;
import com.example.GreenStitchBackendAssignment.entity.LoginDetails;
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
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody UserModel userModel) {
        return new ResponseEntity<User>(userService.createUser(userModel), HttpStatus.CREATED);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello()
    {
        return new ResponseEntity<String>("Hello from GreenStitch", HttpStatus.OK);
    }

    @GetMapping("/current-user")
    public ResponseEntity<String> getCurrentUser(Principal principal)
    {
        return new ResponseEntity<String>(principal.getName(), HttpStatus.OK);
    }

     @PostMapping(path="/login")
    public ResponseEntity<String> login(@RequestBody LoginDetails loginDetails) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDetails.getUserName(), loginDetails.getPassword()));
        if(authentication.isAuthenticated())
            return ResponseEntity.ok().body(jwtService.generateToken(loginDetails.getUserName()));
        else
            return ResponseEntity.status(401).body("Invalid credentials");
    }
    
}
