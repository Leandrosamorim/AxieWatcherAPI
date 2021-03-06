/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.AxieWatcherAPI.controller;

import com.example.AxieWatcherAPI.domain.model.Axie;
import com.example.AxieWatcherAPI.domain.model.AxieDto;
import com.example.AxieWatcherAPI.domain.model.User;
import com.example.AxieWatcherAPI.domain.service.AxieService;
import com.example.AxieWatcherAPI.domain.service.ExternalService;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
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
public class AxieController {
    
    public ExternalService externalService;
    public AxieService axieService;
    
    public AxieController(ExternalService externalService, AxieService axieService){
        this.externalService = externalService;
        this.axieService = axieService;
    }
    
    @RequestMapping(method = {RequestMethod.GET}, value = "/recent") 
    public List<AxieDto> getRecentAxies(){
        return externalService.getAxies();
    }
    
    @PreAuthorize("hasRole('USER')")
    @PostMapping(
        value = "/axies",
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public boolean addFavorite(@RequestBody Axie newAxie){
        if(newAxie.getPrice() == null){
            newAxie.setPrice(newAxie.getAuction().getCurrentPriceUSD());
        }
        return axieService.create(newAxie);
    }
    
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(method = {RequestMethod.DELETE}, value = "/axies") 
    public boolean remove(@RequestParam int id,@RequestParam int userid){
        axieService.delete(id, userid);
        return true;
    }
    
    @RequestMapping(method = {RequestMethod.GET}, value = "/favorites") 
    public List<Axie> favorites(@RequestParam int userid){
        return axieService.findByUser(userid);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = {RequestMethod.GET}, value = "/axies") 
    public List<Axie> getAll(){
        return axieService.findAll();
    }
    
    @RequestMapping(method = {RequestMethod.GET}, value = "/get") 
    public Axie getbyId(Integer id){
        return axieService.findById(id);
    }
    
    
    
    
    
    

}
