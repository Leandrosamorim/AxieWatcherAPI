/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.AxieWatcherAPI.domain.model;

import com.example.AxieWatcherAPI.util.Auction;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 55229
 */
@Entity
@Table(name = "axies")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Axie.findAll", query = "SELECT a FROM Axie a"),
    @NamedQuery(name = "Axie.findById", query = "SELECT a FROM Axie a WHERE a.id = :id"),
    @NamedQuery(name = "Axie.findByName", query = "SELECT a FROM Axie a WHERE a.name = :name"),
    @NamedQuery(name = "Axie.findByClass1", query = "SELECT a FROM Axie a WHERE a.class1 = :class1"),
    @NamedQuery(name = "Axie.findByOwner", query = "SELECT a FROM Axie a WHERE a.owner = :owner"),
    @NamedQuery(name = "Axie.findByBreedCount", query = "SELECT a FROM Axie a WHERE a.breedCount = :breedCount"),
    @NamedQuery(name = "Axie.findByImage", query = "SELECT a FROM Axie a WHERE a.image = :image"),
    @NamedQuery(name = "Axie.findByPrice", query = "SELECT a FROM Axie a WHERE a.price = :price")})
public class Axie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @JsonProperty
    private Integer id;
    @Column(name = "name")
    @JsonProperty
    private String name;
    @Column(name = "class")
    @JsonProperty("class")
    private String class1;
    @Column(name = "owner")
    @JsonProperty
    private String owner;
    @Column(name = "breedCount")
    @JsonProperty
    private Integer breedCount;
    @Column(name = "image")
    @JsonProperty
    private String image;
    @Column(name = "price")
    private String price;
    @JsonProperty
    @Transient
    private Auction auction;
    @Column(name = "userid")
    private Integer userid;

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public Axie(Integer id, String name, String class1, String owner, Integer breedCount, String image, Auction auction, int userid) {
        this.id = id;
        this.name = name;
        this.class1 = class1;
        this.owner = owner;
        this.breedCount = breedCount;
        this.image = image;
        this.price = auction.getCurrentPriceUSD();
        this.auction = auction;
        this.userid = userid;
    }

    public Axie() {
    }

    public Axie(Integer id) {
        this.id = id;
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

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Axie)) {
            return false;
        }
        Axie other = (Axie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.AxieWatcherAPI.domain.model.Axie[ id=" + id + " ]";
    }
    
}
