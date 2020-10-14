package com.ifmo.jjd.lesson7.farm;

public interface FarmAnimalActions {
    void takeWounds(int wounds);
    void aliveCheck();
    void addHealthPoints(int hp);
    boolean runFromWildAnimal (WildAnimal animal);
}
