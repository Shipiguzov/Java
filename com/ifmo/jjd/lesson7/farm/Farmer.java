package com.ifmo.jjd.lesson7.farm;

final public class Farmer {

    // Фермер собирает ресурсы с Animal
    public int gatheringResources(FarmAnimal animal) {
        return animal.getResources();
    }

    public int spendResources(int resources) {
        System.out.println("Farmer had spend " + resources + " resources.");
        return resources;
    }

    public int eatFarmAnimal(FarmAnimal animal) {
        if (animal.isAlive() && animal.getResources() > 0) {
            animal.takeWounds(animal.getHealth());
            animal.aliveCheck();
            System.out.println("Farmer ate " + animal.getName());
            return animal.getWeight();
        }
        return 0;
    }

    public void chaseWildAnimal(WildAnimal animal) {
        if (Farm.randomNumber(0, 100) > 10 * animal.getStrength()) {
            animal.takeFear();
            System.out.println("Farmer chased " + animal.getName());
        }
    }

    public void feedAnimal(FarmAnimal animal) {
        if (animal.isAlive()) {
            animal.addHealthPoints(1);
            System.out.println("Farmer feed " + animal.name);
        }
    }

}
