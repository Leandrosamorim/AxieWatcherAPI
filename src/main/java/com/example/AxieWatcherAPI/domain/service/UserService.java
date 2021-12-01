/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.AxieWatcherAPI.domain.service;

import com.example.AxieWatcherAPI.domain.model.User;
import com.example.AxieWatcherAPI.repository.UserRepository;
import java.util.List;
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
    
    public boolean create(User user)
    {
        userRepository.save(user);
        return true;
    }
    
    public User edit(User user)
    {
        userRepository.save(user);
        return user;
    }
    
    public User findById(Long id)
    {
        return userRepository.findById(id).get();
    }
    
    public List<User> findAll(){
        return userRepository.findAll();
    }
    
    public boolean delete(int id){
        userRepository.removeById(id);
        return true;
    }
    
}
