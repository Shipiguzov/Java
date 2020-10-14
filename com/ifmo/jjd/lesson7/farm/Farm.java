package com.ifmo.jjd.lesson7.farm;

final public class Farm {
    FarmAnimal[] farmAnimals = new FarmAnimal[10];
    Farmer farmer = new Farmer();
    private int resources = 5;
    private int resourcesPerDay = 2;
    private boolean emptyFarm = false;


    //возвращает случайное число от minRange до maxRange
    public static int randomNumber(int minRange, int maxRange) {
        return (int) (Math.random() * (maxRange - minRange + 1)) + minRange;
    }

    public int getResources() {
        return resources;
    }

    public boolean gameOver() {
        if (resources < resourcesPerDay - 1) return true;
        return false;
    }

    private int freePlaceOnFarm() {
        for (int i = 0; i < farmAnimals.length; i++) {
            if (this.farmAnimals[i] == null) return i;
        }
        return -1;
    }

    public void addFarmAnimal(FarmAnimal animal) {
        if (this.freePlaceOnFarm() >= 0) {
            farmAnimals[this.freePlaceOnFarm()] = animal;
        } else System.out.println("No place on farm for farmAnimal");
    }

    private boolean aliveEatableAnimal() {
        int count = 0;
        for (FarmAnimal farmAnimal : farmAnimals) {
            if (farmAnimal.isEatable() && farmAnimal.isAlive()) count++;
        }
        if (count != 0) return true;
        return false;
    }

    private void emptyFarm() {
        int count = 0;
        for (FarmAnimal farmAnimal : farmAnimals) {
            if (!farmAnimal.isAlive()) count++;
        }
        if (count == this.farmAnimals.length) this.emptyFarm = true;
    }

    public void dayOnFarm(WildAnimal animal) {
        this.emptyFarm();
        this.resources -= farmer.spendResources(resourcesPerDay);
        if (!this.emptyFarm) {
            farmer.chaseWildAnimal(animal);

            //wild animal attack on farm
            if (animal.isAttackOnFarm()) {
                int i;
                while (true) {
                    i = this.randomNumber(0, farmAnimals.length - 1);
                    if (this.farmAnimals[i].isAlive()) break;
                }
                animal.attackOnFarmAnimal(farmAnimals[i]);
            }

            //Farmer is feeding animal on farm and gathering resources
            int countResourcesFromFarmAnimal = 0;
            for (FarmAnimal farmAnimal : farmAnimals) {
                farmer.feedAnimal(farmAnimal);
                if (farmAnimal.getResources() > 0 && farmAnimal.isAlive()) {
                    this.resources += farmer.gatheringResources(farmAnimal);
                    countResourcesFromFarmAnimal++;
                }
            }

            //Farmer eat farm animal
            if (countResourcesFromFarmAnimal == 0 && this.aliveEatableAnimal()) {
                do {
                    int i = Farm.randomNumber(0, farmAnimals.length - 1);
                    if (farmAnimals[i].isAlive() && farmAnimals[i].isEatable()) {
                        this.resources += farmer.eatFarmAnimal(farmAnimals[i]);
                        break;
                    }
                } while (true);
            }
        }
    }
}

