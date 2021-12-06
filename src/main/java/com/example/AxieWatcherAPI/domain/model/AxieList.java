/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.AxieWatcherAPI.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 55229
 */
public class AxieList {

    @JsonProperty
    private List<AxieDto> results;
    @JsonProperty
    private int total;

    public AxieList() {
        results = new ArrayList<>();
    }
    
    public List<AxieDto> getAxies(){
        return results;
    }
    
}
