/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.App.services;

import com.example.App.entities.UserEntity;
import com.example.App.pojos.LoginRequest;
import com.example.App.pojos.LoginResponse;
import com.example.App.pojos.Register;
import com.example.App.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author garla
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public void insertData(Register userData){
        UserEntity registerEntity = new UserEntity();
        registerEntity.setEmail(userData.getEmail());
        registerEntity.setFirstName(userData.getFirstName());
        registerEntity.setLastName(userData.getLastName());
        registerEntity.setPassword(userData.getPassword());
        userRepository.save(registerEntity);
    }
    
    public LoginResponse authenticateUser(LoginRequest loginData){
        UserEntity userEntity = userRepository.findByEmail(loginData.getEmail());
        LoginResponse loginResponse = new LoginResponse();
        if(userEntity != null){
            if(userEntity.getPassword().equals(loginData.getPassword())){
                //Succesful authentication.
                loginResponse.setStatus(0);
                loginResponse.setEmail(userEntity.getEmail());
                loginResponse.setFirstName(userEntity.getFirstName());
                loginResponse.setLastName(userEntity.getLastName());
            }else{
                //Password doesn't match.
                loginResponse.setStatus(1);
            }
        }else{
            //User doesn't exist.
           loginResponse.setStatus(2); 
        }
        return loginResponse;
    }
}
