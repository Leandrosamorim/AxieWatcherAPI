/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.AxieWatcherAPI.controller;

import com.example.AxieWatcherAPI.domain.model.User;
import com.example.AxieWatcherAPI.domain.service.UserService;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 55229
 */
@RestController
public class UserController {
    
    private final UserService userService;
    
    public UserController(UserService userService){
        this.userService = userService;
    }
    
    @RequestMapping(method = {RequestMethod.GET}, value = "/users") 
    public List<User> getUsers(){
        return userService.findAll();
    }
    
    @PostMapping(
        value = "/users",
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public boolean add(@RequestBody User newUser){
        return userService.create(newUser);
    }
    
    @RequestMapping(method = {RequestMethod.DELETE}, value = "/users") 
    public boolean remove(@RequestParam int id){
        userService.delete(id);
        return true;
    }
    
    @PutMapping(value = "/users",
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public User edit(@RequestBody User user){
        return userService.edit(user);
    }
    
}
