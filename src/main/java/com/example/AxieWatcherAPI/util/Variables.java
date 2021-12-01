/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.AxieWatcherAPI.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 *
 * @author 55229
 */
public class Variables {
    @JsonProperty
    public int from;
    @JsonProperty
    public int size;
    @JsonProperty
    public String sort;
    @JsonProperty
    public String auctionType;
    @JsonProperty
    public List<Object> criteria;
    
    public Variables(){
        this.from = 0;
        this.size = 10;
        this.sort = "PriceAsc";
        this.auctionType = "Sale";
    }
    
}
