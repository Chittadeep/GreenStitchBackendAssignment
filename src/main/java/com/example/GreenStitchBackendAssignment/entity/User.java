package com.example.GreenStitchBackendAssignment.entity;


import com.example.GreenStitchBackendAssignment.model.UserModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "User cannot be created without name")
    private String name;
    @NotBlank(message = "User cannot be created without email")
    private String email;

    public User(UserModel userModel)
    {
        this.name = userModel.getName();
        this.email = userModel.getEmail();
    }
    
}
