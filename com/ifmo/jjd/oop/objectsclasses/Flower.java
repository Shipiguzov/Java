package com.ifmo.jjd.objectsclasses;

public class Flower {
    private String name;
    private String country;
    private int maxDays;
    private int price;

    public Flower(String name, String country, int maxDays, int price) {
        if (name == null || name.trim().length() <3)
            throw new IllegalArgumentException("name");
        if (country == null || country.trim().length() <3)
            throw new IllegalArgumentException("country");
        if (maxDays <= 0)
            throw new IllegalArgumentException("not 0");
        if (price <= 0)
            throw new IllegalArgumentException("not 0");
        this.name = name;
        this.country = country;
        this.maxDays = maxDays;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getMaxDays() {
        return maxDays;
    }

    public int getPrice() {
        return price;
    }
}
