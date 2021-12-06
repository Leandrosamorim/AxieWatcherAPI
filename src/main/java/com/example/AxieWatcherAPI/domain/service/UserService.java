/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.AxieWatcherAPI.domain.service;

import com.example.AxieWatcherAPI.domain.model.User;
import com.example.AxieWatcherAPI.repository.UserRepository;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author 55229
 */
@Service
public class UserService {
    
      private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    public User create(User user)
    {
        String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        User createdUser = userRepository.getByUsername(user.getUsername());
        return createdUser;
    }
    
    public User edit(User user)
    {
        userRepository.save(user);
        return user;
    }
    
    public User findById(Integer id)
    {
        return userRepository.getById(id);
    }
    
    public List<User> findAll(){
        return userRepository.findAll();
    }
    
    public boolean delete(int id){
        userRepository.removeById(id);
        return true;
    }

    public User findByUsername(String username) {
        return userRepository.getByUsername(username);
    }
    
}
