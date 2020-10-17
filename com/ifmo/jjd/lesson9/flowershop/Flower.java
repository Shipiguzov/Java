package com.ifmo.jjd.lesson9.flowershop;

import java.util.Objects;

public final class Flower {
    private String name;
    private String country;
    private int price;
    private int storageDays;

    public Flower(String name, String country, int price, int storageDays) {
        this.setName(name);
        this.setCountry(country);
        this.setPrice(price);
        this.setStorageDays(storageDays);
    }

    public void setName(String name) {
        if (name == null || name.trim().length() < 3) throw new IllegalArgumentException("wrong name");
        this.name = name;
    }

    public void setCountry(String country) {
        if (country == null || country.trim().length() < 3) throw new IllegalArgumentException("wrong country");
        this.country = country;
    }

    public void setPrice(int price) {
        if (price < 0) throw new IllegalArgumentException("price < 0");
        this.price = price;
    }

    public void setStorageDays(int storageDays) {
        if (storageDays < 1) throw new IllegalArgumentException("storageDays < 1");
        this.storageDays = storageDays;
    }

    public int getPrice() {
        return price;
    }

    public int getStorageDays() {
        return storageDays;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "name='" + name + '\'' +
                /*", country='" + country + '\'' +
                ", price=" + price +
                ", storageDays=" + storageDays +*/
                '}';
    }
}
