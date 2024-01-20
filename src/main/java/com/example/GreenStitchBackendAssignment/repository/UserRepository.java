package com.example.GreenStitchBackendAssignment.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.GreenStitchBackendAssignment.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    
}
