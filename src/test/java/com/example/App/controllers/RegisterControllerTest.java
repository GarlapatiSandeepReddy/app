package com.example.App.controllers;

import com.example.App.pojos.Register;
import com.example.App.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RegisterController.class)
public class RegisterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserService userService;

    @Test
    public void testRegister() throws Exception {
        // Create a sample Register object
        Register register = new Register();
        register.setFirstName("John");
        register.setLastName("Doe");
        register.setEmail("john@example.com");
        register.setPassword("password");

        // Convert Register object to JSON string
        String requestBody = objectMapper.writeValueAsString(register);

        // Mock the userService.insertData() method
        doNothing().when(userService).insertData(any(Register.class));

        // Perform POST request to /register endpoint with JSON body
        mockMvc.perform(MockMvcRequestBuilders.post("/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk());

        // Verify that userService.insertData() was called with the correct argument
        verify(userService, times(1)).insertData(any(Register.class));
    }
}
