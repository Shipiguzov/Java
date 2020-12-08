package com.ifmo.jjd.lesson7;

// класс Unit имплементирует интерфейс RestAble, соответсвенно обязан
// реализовать все методы без реализации данного интерфейса,
// либо класс дб abstract

// abstract класс могут содержать методы без реализации
// abstract класс могут содержать методы с реализацией
// на основе abstract класса нельзя создать объект (new Unit())
abstract public class Unit implements RestAble{
    protected int healthPoints;
    protected int agilityPoints;

    protected final int maxHealth;

    public Unit(int healthPoints, int agilityPoints) {
        if (healthPoints <= 0 || agilityPoints <= 0)
            throw new IllegalArgumentException("healthPoints < 0 || agilityPoints < 0");
        maxHealth = healthPoints;
        this.healthPoints = healthPoints;
        this.agilityPoints = agilityPoints;
    }

    public void plusHealth(int points) {
        if (isAlive()) {
            healthPoints += points;
            if (healthPoints > maxHealth) healthPoints = maxHealth;
        }
    }

    public void minusHealth(int points){
        if (isAlive()) {
            healthPoints -= points;
            if (!isAlive()) healthPoints = 0;
        }
    }

    public boolean isAlive(){
        return healthPoints > 0;
    }
}


