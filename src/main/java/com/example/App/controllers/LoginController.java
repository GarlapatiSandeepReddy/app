/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.App.controllers;

import com.example.App.JWT.JwtUtil;
import com.example.App.pojos.LoginRequest;
import com.example.App.pojos.LoginResponse;
import com.example.App.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author garla
 */
@RestController
public class LoginController {
    
    @Autowired
    UserService userService;
    
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginData){
        System.out.println(loginData.toString());
        LoginResponse loginResponse = userService.authenticateUser(loginData);
        System.out.println(loginResponse.toString());
        if(loginResponse.getStatus() == 0){
            String jwtToken = JwtUtil.generateToken(loginData.getEmail());
            loginResponse.setJwtToken(jwtToken);
        }
        return loginResponse;
    }
}
