package com.ifmo.jjd.lesson6.homework2;

import java.util.Arrays;

public class MyFood {
    private int fatAllow;
    private int proteinAllow;
    private int carbohydratesAllow;
    private Food[] listOfFood = new Food[2];
    private boolean flag = false;

    public int getFatAllow() {
        return fatAllow;
    }

    public void setFatAllow(int fatAllow) {
        if (fatAllow < 0) throw new IllegalArgumentException("fatAllow not less 0");
        this.fatAllow = fatAllow;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        if (flag != true && flag != false) throw new IllegalArgumentException("flag must be boolean");
        this.flag = flag;
    }

    public int getProteinAllow() {
        return proteinAllow;
    }

    public void setProteinAllow(int proteinAllow) {
        if (proteinAllow < 0) throw new IllegalArgumentException("proteinAllow not less 0");
        this.proteinAllow = proteinAllow;
    }

    public int getCarbohydratesAllow() {
        return carbohydratesAllow;
    }

    public void setCarbohydratesAllow(int carbohydratesAllow) {
        if (carbohydratesAllow < 0) throw new IllegalArgumentException("carbohydtatesAllow not less 0");
        this.carbohydratesAllow = carbohydratesAllow;
    }

    public Food[] getListOfFood() {
        return listOfFood;
    }

    public void setListOfFood(Food food) {
        int count = 0;
        this.setFlag(true);
        for (int i = 0; i < this.listOfFood.length; i++) {
            if (this.listOfFood[i] == null) {
                break;
            } else {
                count += 1;
            }
        }
        if (count == this.listOfFood.length) throw new IllegalArgumentException("listOfFood is full");
        if (food.getFat() > this.getFatAllow()
                || food.getProtein() > this.getProteinAllow()
                || food.getCarbohydrates() > this.getCarbohydratesAllow()) {
            System.out.println(food.getName() + " is too heavy!");
            this.setFlag(false);
            return;
        }
        for (int i = 0; i < this.listOfFood.length; i++) {
            if (this.listOfFood[i] == null) {
                this.listOfFood[i] = food;
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "MyFood{" +
                ", fatAllow=" + fatAllow +
                ", proteinAllow=" + proteinAllow +
                ", carbohydratesAllow=" + carbohydratesAllow +
                ", listOfFood=" + Arrays.toString(listOfFood) +
                '}';
    }
}
