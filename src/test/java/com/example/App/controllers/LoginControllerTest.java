/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.App.controllers;

import com.example.App.pojos.LoginRequest;
import com.example.App.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author garla
 */
@WebMvcTest(LoginController.class)
public class LoginControllerTest{
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @MockBean
    private UserService userService;
    
    private LoginRequest login;
    
    @BeforeEach
    public void setup(){
        login = new LoginRequest();
        login.setEmail("kavyag@gmail.com");
        login.setPassword("password");
    }
    
//    @Test
//    public void loginSuccesful() throws Exception{
//        
//        String requestBody = objectMapper.writeValueAsString(login);
//        
//        when(userService.authenticateUser(any(LoginRequest.class))).thenReturn(0);
//        
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/login")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content(requestBody)).andExpect(status().isOk()).andReturn();
//        
//        verify(userService, times(1)).authenticateUser(any(LoginRequest.class));
//        
//        assertEquals(result.getResponse().getContentAsString(), "LoginRequest Successful.");
//    }
//    
//    @Test
//    public void passwordMismatch() throws Exception{
//        
//        String requestBody = objectMapper.writeValueAsString(login);
//        
//        when(userService.authenticateUser(any(LoginRequest.class))).thenReturn(1);
//        
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/login")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content(requestBody)).andExpect(status().isOk()).andReturn();
//        
//        verify(userService, times(1)).authenticateUser(any(LoginRequest.class));
//        
//        assertEquals(result.getResponse().getContentAsString(), "Password mismatch");
//    }
//    
//    @Test
//    public void userDoesntExist() throws Exception{
//        
//        String requestBody = objectMapper.writeValueAsString(login);
//        
//        when(userService.authenticateUser(any(LoginRequest.class))).thenReturn(2);
//        
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/login")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content(requestBody)).andExpect(status().isOk()).andReturn();
//        
//        verify(userService, times(1)).authenticateUser(any(LoginRequest.class));
//        
//        assertEquals(result.getResponse().getContentAsString(), "User doesn't exist");
//    }
}
