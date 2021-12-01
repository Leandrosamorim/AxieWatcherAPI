/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.AxieWatcherAPI.util;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author 55229
 */
public class Data {
    @JsonProperty
    private Axies data;
    
    public Data(){
        this.data = new Axies();
    }
    
    public Axies getAxies(){
        return this.data;
    }
}
