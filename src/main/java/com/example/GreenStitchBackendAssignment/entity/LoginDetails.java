package com.example.GreenStitchBackendAssignment.entity;

import com.example.GreenStitchBackendAssignment.model.UserModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class LoginDetails {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Login details cannot be created without user name")
    @Column(unique = true)
    private String userName;
    @NotBlank(message = "Login details cannot be created without password")
    private String password;

    public LoginDetails(UserModel userModel)
    {
        this.userName = userModel.getName();
        this.password = userModel.getPassword();
    }

    public LoginDetails(){}
}
