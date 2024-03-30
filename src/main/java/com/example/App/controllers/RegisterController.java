/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.App.controllers;

import com.example.App.pojos.Register;
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
public class RegisterController {
    
    @Autowired
    UserService userService;
    
    @PostMapping("/register")
    public String register(@RequestBody Register registerData){
        System.out.println(registerData.toString());
        userService.insertData(registerData);
        return "Register Request Received!";
    }
}
