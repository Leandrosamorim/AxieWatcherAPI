/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.AxieWatcherAPI.repository;

import com.example.AxieWatcherAPI.domain.model.Axie;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 55229
 */
@Repository
public interface AxieRepository extends JpaRepository<Axie, Integer>{

    public List<Axie> findByOwner(String ownerId);

    public List<Axie> findByUserid(int userId);
    
    @Transactional
    @Modifying
    @Query("delete from Axie where id=:id and userId=:userId")
    public void removeByIdAndUserid(int id, int userId);
    
}
