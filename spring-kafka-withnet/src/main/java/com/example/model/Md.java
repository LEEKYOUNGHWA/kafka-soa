package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Md {

    public Md() {

    }
    public Md(String key, String name) {
    	this.key = key;
    	this.name = name;
    }

    @Id
    private String key;
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getkey() {
        return key;
    }

    public void setkey(String key) {
        this.key = key;
    }
}
