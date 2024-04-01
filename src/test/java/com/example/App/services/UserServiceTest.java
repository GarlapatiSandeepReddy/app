/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.App.services;

import com.example.App.entities.UserEntity;
import com.example.App.pojos.Register;
import com.example.App.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author garla
 */
@SpringBootTest
public class UserServiceTest {
    
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    public UserServiceTest() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    public void testInserData(){
        Register register = new Register();
        register.setFirstName("Kavya");
        register.setLastName("Gurram");
        register.setEmail("kavyag@gmail.com");
        register.setPassword("kavyag");
        
        UserEntity registerEntity = new UserEntity();
        registerEntity.setFirstName(register.getFirstName());
        registerEntity.setLastName(register.getLastName());
        registerEntity.setEmail(register.getEmail());
        registerEntity.setPassword(register.getPassword());
        
        
        when(userRepository.save(any(UserEntity.class))).thenReturn(registerEntity);

        // Call the insertData() method of userService
        userService.insertData(register);

        // Verify that userRepository.save() was called with the correct argument
        verify(userRepository, times(1)).save(any(UserEntity.class));
        
    }
    
}
