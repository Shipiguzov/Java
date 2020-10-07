package com.ifmo.jjd.lesson6.homework2;

public class Food {
    private String name;
    private int fat;
    private int protein;
    private int carbohydrates;

    public Food() {}

    public Food(String name) {
        this.setName(name);
    }

    public Food(String name, int carbohydrates) {
        this.setName(name);
        this.setCarbohydrates(carbohydrates);
    }

    public Food(String name, int fat, int protein, int carbohydrates) {
        this.setName(name);
        this.setFat(fat);
        this.setProtein(protein);
        this.setCarbohydrates(carbohydrates);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() < 3) throw new IllegalArgumentException("Name 3 or more characters");
        this.name = name;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        if (fat < 0) throw new IllegalArgumentException("Fat must be 0 or more");
        this.fat = fat;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        if (protein < 0) throw new IllegalArgumentException("Proteins must be 0 or more");
        this.protein = protein;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates) {
        if (carbohydrates < 0) throw new IllegalArgumentException("Carbohydrates must be 0 or more");
        this.carbohydrates = carbohydrates;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", fat=" + fat +
                ", protein=" + protein +
                ", carbohydrates=" + carbohydrates +
                '}';
    }
}
