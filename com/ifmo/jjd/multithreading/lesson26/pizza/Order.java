package com.ifmo.jjd.multithreading.lesson26.pizza;

import java.util.Objects;
import java.util.Random;

public final class Order {

    int price = 0;
    String name = "default";

    public Order(String name, int price) {
        this.setPrice(price);
        this.setName(name);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price < 0) throw new IllegalArgumentException("Price must be 0 or more");
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (Objects.isNull(name) || name.length() < 3) throw new IllegalArgumentException("Name of dish must be 2 or more chars");
        this.name = name;
    }

    public static Order generateNewDish() {
        Random random = new Random();
        String[] names = {"Soup", "Spagetti", "Meat", "Desert", "Beverages"};
        return new Order(names[random.nextInt(names.length)], random.nextInt(1000));
    }

    @Override
    public String toString() {
        return "Order{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
