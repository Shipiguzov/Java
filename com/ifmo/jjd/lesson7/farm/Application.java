package com.ifmo.jjd.lesson7.farm;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Farm farm = new Farm();
        WildAnimal[] wildAnimalList = new WildAnimal[3];
        int dayNumber = 1;

        for (int i = 0; i < farm.farmAnimals.length; i++) {
            farm.addFarmAnimal(MakeLists.chooseFarmAnimal());
        }
        for (int i = 0; i < wildAnimalList.length; i++) {
            wildAnimalList[i] = MakeLists.chooseWildAnimal(i);
        }

        do {
            farm.dayOnFarm(wildAnimalList[Farm.randomNumber(0, 2)]);
            System.out.println("Day " + dayNumber + " has passed.");
            System.out.println("There is " + farm.getResources() + " resurces  on farm");
            dayNumber++;
            if (dayNumber >= 1000) {
                System.out.println("Farm will be forever");
                break;
            }
        } while (!farm.gameOver());
        if (dayNumber < 1000) System.out.println("GAME OVER!");
    }
}
