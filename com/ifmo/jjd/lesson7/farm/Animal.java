package com.ifmo.jjd.lesson7.farm;

import java.util.Objects;

public class Animal {
    protected String name;
    protected int weight;
    protected int speed;

    public Animal(String name, int weight, int speed) {
        this.setName(name);
        this.setWeight(weight);
        this.setSpeed(speed);
    }

    public void setName(String name) {
        name.trim();
        if (name == null || name.length() < 2) throw new IllegalArgumentException("name < 2 characters");
        this.name = name;
    }

    public void setWeight(int weight) {
        Objects.requireNonNull(weight, "Weight < 0");
        this.weight = weight;
    }

    public void setSpeed(int speed) {
        Objects.requireNonNull(speed, "speed < 0");
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getSpeed() {
        return speed;
    }
}
