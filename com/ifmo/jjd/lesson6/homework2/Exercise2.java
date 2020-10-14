package com.ifmo.jjd.lesson6.homework2;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String nameOfFood;
        int fat, carbohydrates, protein, count = 0;
        MyFood food;

        food = new MyFood();

        System.out.println("Enter how much proteins allowed: ");
        protein = input.nextInt();
        System.out.println("Enter how much fat allowed: ");
        fat = input.nextInt();
        System.out.println("Enter how much carbonhydrates allowed: ");
        carbohydrates = input.nextInt();
        food.setCarbohydratesAllow(carbohydrates);
        food.setFatAllow(fat);
        food.setProteinAllow(protein);
        do {
            System.out.println("Enter food name: ");
            nameOfFood = input.nextLine();
            if (nameOfFood != "") {
                System.out.println("Enter fat in " + nameOfFood);
                fat = input.nextInt();
                System.out.println("Enter proteins in " + nameOfFood);
                protein = input.nextInt();
                System.out.println("Enter carbohydrates in " + nameOfFood);
                carbohydrates = input.nextInt();
                Food currentFood = new Food(nameOfFood, fat, protein, carbohydrates);
                food.setListOfFood(currentFood);
                if (food.isFlag()) count++;
            }
        } while (count < food.getListOfFood().length);

        System.out.println(food.toString());
    }
}
