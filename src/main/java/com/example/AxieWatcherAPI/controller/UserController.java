/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.AxieWatcherAPI.controller;

import com.example.AxieWatcherAPI.domain.model.User;
import com.example.AxieWatcherAPI.domain.service.FileService;
import com.example.AxieWatcherAPI.domain.service.UserService;
import java.io.File;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author 55229
 */
@RestController
public class UserController {
    
    private final UserService userService;
    private final FileService fileService;
    
    public UserController(UserService userService, FileService fileService){
        this.userService = userService;
        this.fileService = fileService;
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = {RequestMethod.GET}, value = "/users") 
    public List<User> getUsers(){
        return userService.findAll();
    }
    
    /**
     *
     * @param newUser
     * @param newFile
     * @return
     */
    @PostMapping(
        value = "/users",
        consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.IMAGE_JPEG_VALUE},
        produces = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.IMAGE_JPEG_VALUE})
    public String add(@RequestPart("newUser") User newUser, @RequestPart("newFile") MultipartFile newFile){
        User user = userService.create(newUser);
        if(user != null){
        fileService.uploadFile(newFile, user.getId().toString());
        }
        return "true";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = {RequestMethod.DELETE}, value = "/users") 
    public boolean remove(@RequestParam int id){
        userService.delete(id);
        return true;
    }
    
    @PreAuthorize("hasRole('USER')")
    @PutMapping(value = "/users",
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public User edit(@RequestBody User user){
        return userService.edit(user);
    }
    
    @RequestMapping(method = {RequestMethod.GET}, value = "/getUser") 
    public User getById(@RequestParam int id){
        return userService.findById(id);
    }
    
    @GetMapping(value = "/auth",
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.ALL_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE})
    public User getByEmail(@RequestParam String username){
        return userService.findByUsername(username);
    }
    
}
