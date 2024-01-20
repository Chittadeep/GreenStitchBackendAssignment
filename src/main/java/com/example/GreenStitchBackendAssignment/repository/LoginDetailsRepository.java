package com.example.GreenStitchBackendAssignment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.GreenStitchBackendAssignment.entity.LoginDetails;

@Repository
public interface LoginDetailsRepository extends CrudRepository<LoginDetails, Integer>{
    public LoginDetails getLoginDetailsByUserName(String userName);

}
