/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.AxieWatcherAPI.domain.model;

import com.example.AxieWatcherAPI.util.Auction;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;

/**
 *
 * @author 55229
 */
public class AxieDto {
    @JsonProperty
    private Integer id;
    @JsonProperty
    private String name;
    @JsonProperty("class")
    private String class1;
    @JsonProperty
    private String owner;
    @JsonProperty
    private Integer breedCount;
    @JsonProperty
    private String image;
    @JsonProperty
    private String price;
    @JsonProperty
    private Auction auction;

    public AxieDto(Integer id, String name, String class1, String owner, Integer breedCount, String image, String price, Auction auction) {
        this.id = id;
        this.name = name;
        this.class1 = class1;
        this.owner = owner;
        this.breedCount = breedCount;
        this.image = image;
        this.price = price;
        this.auction = auction;
    }

    public AxieDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getBreedCount() {
        return breedCount;
    }

    public void setBreedCount(Integer breedCount) {
        this.breedCount = breedCount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }
    
}
