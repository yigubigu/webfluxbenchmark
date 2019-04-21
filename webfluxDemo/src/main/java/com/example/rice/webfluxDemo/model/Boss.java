package com.example.rice.webfluxDemo.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Boss {
    @Id
    public String id;
    public String name;
    public String weapon;
    public String weakness;

    // Constructors
    public Boss() {
    }

    public Boss(String id, String name, String weapon, String weakness) {
        this.id = id;
        this.name = name;
        this.weapon = weapon;
        this.weakness = weakness;
    }

    // ObjectId needs to be converted to string
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }
}