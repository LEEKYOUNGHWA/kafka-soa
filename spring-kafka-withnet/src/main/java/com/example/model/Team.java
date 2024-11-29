package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Team {

    public Team() {

    }
    public Team(String key, String name) {
        this.name = name;
        this.key = key;
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
