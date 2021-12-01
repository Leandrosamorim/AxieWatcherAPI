/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.AxieWatcherAPI.domain.service;

import com.example.AxieWatcherAPI.domain.model.Axie;
import com.example.AxieWatcherAPI.repository.AxieRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author 55229
 */
@Service
public class AxieService {
    
    private final AxieRepository axieRepository;
    
    public AxieService(AxieRepository axieRepository){
        this.axieRepository = axieRepository;
    }
    
    public boolean create(Axie axie)
    {
        axieRepository.save(axie);
        return true;
    }
    
    public boolean edit(Axie axie)
    {
        axieRepository.save(axie);
        return true;
    }
    
    public Axie findById(Long id)
    {
        return axieRepository.findById(id).get();
    }
    
    public List<Axie> findByOwner(String ownerId){
        return axieRepository.findByOwner(ownerId);
    }
    
    public List<Axie> findByUser(int userId){
        return axieRepository.findByUserid(userId);
    }
    
    public List<Axie> findAll(){
        return axieRepository.findAll();
    }
    
    public boolean delete(int id, int userId){
        axieRepository.removeByIdAndUserid(id, userId);
        return true;
    }
}
