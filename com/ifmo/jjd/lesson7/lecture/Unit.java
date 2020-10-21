package com.ifmo.jjd.lesson7.lecture;

// класс Unit имплементирует интерфейс RestAble, соответственно обязан реализовать все методы без реализации данного интерфейса,
// либо класс должен быть abstract

// abstract класс могут содержать методы без реализацией
// abstract класс могут содержать методы с реализацией
// на основе abstrack класса нельзя создать объект (не можем написать new Unit() )
abstract public class Unit implements RestAble{

    protected int healthPoints;
    protected int agilityPoints;

    protected int maxHealth;

    public Unit(int healthPoints, int agilityPoints) {
        if (healthPoints <= 0 || agilityPoints <= 0)
            throw new IllegalArgumentException("healthPoints <= 0 !! agilityPoints <= 0");
        this.healthPoints = healthPoints;
        this.agilityPoints = agilityPoints;
        maxHealth = healthPoints;
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
