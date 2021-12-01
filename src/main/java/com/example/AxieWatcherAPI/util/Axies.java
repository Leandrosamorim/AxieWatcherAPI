/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.AxieWatcherAPI.util;

import com.example.AxieWatcherAPI.domain.model.AxieList;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author 55229
 */
public class Axies {

    @JsonProperty
    private AxieList axies;

    public Axies() {
        this.axies = new AxieList();
    }

    public AxieList getAxieList() {
        return this.axies;
    }
}
