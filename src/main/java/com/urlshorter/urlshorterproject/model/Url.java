package com.urlshorter.urlshorterproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String orignalUrl;
    private String shortUrl;
    //getter and setter


    public void setId(Long id) {
        this.id = id;
    }

    public void setOrignalUrl(String orignalUrl) {
        this.orignalUrl = orignalUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public Long getId() {
        return id;
    }

    public String getOrignalUrl() {
        return orignalUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    @Override
    public String toString() {
        return "Url{" +
                "id=" + id +
                ", orignalUrl='" + orignalUrl + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                '}';
    }
}
