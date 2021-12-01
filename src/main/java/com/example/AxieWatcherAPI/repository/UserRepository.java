/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.AxieWatcherAPI.repository;

import com.example.AxieWatcherAPI.domain.model.User;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 55229
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{ 
    
     @Transactional
    @Modifying
    public void removeById(int id);
    
}
