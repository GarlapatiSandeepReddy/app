/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.App.repositories;

import com.example.App.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author garla
 */
public interface UserRepository extends JpaRepository<UserEntity, Long>{
    UserEntity findByEmail(String email);
}
