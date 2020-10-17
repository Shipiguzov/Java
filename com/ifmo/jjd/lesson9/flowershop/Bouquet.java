package com.ifmo.jjd.lesson9.flowershop;

import java.util.Arrays;
import java.util.Objects;

public final class Bouquet {
    Flower[] flowers = new Flower[5];
    private static int id;
    private String name;
    private int cost = 0;
    private double storageDays = 0;

    public Bouquet(String name, int id) {
        this.setName(name);
        this.id = id;
    }



    public void addFlower() {
        int count = 0;
        for (int i = 0; i < this.flowers.length; i++) {
            if (this.flowers[i] == null) {
                this.flowers[i] = Service.flower(Service.randomNumber(0, 4));
                break;
            }
            count++;
        }
        if (count == this.flowers.length) System.out.println("В букете нету места для нового цветка");
    }

    public void setName(String name) {
        if (name == null || name.trim().length() < 3) throw new IllegalArgumentException("Wrong name of bouquet.");
        this.name = name;
    }

    public static void setId(int id) {
        Bouquet.id = id;
    }

    public int getId() {
        return id;
    }

    public int getCost() {
        return cost;
    }

    public double getStorageDays() {
        return storageDays;
    }

    public void takeCost() {
        for (Flower flower : this.flowers) {
            if (flower != null) this.cost += flower.getPrice();
        }
    }

    public void takeStorageDays() {
        int count = 0;
        for (Flower flower : this.flowers) {
            if (flower != null) this.storageDays += flower.getStorageDays();
            count++;
        }
        this.storageDays /= count;
    }

    @Override
    public String toString() {
        return "Bouquet{" +
                "flowers=" + Arrays.toString(flowers) +
                ", name='" + name + '\'' +
                ", ID='" + this.getId() + '\'' +
                '}';
    }
}
