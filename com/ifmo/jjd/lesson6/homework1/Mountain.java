package com.ifmo.jjd.lesson6.homework1;

public class Mountain {
    private String name;
    private String country;
    private int height;

    public Mountain(String name) {
        this.name = name;
    }

    public Mountain(String name, String country, int height) {
        this.setName(name);
        this.setCountry(country);
        this.setHeight(height);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() < 3) throw new IllegalArgumentException("Имя не менее 4 букв");
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (country == null || country.length() < 3) throw new IllegalArgumentException("Название страны не менее 4 букв");
        this.country = country;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height < 99) throw new IllegalArgumentException("Высота должна быть на менее 100 метров");
        this.height = height;
    }

    @Override
    public String toString() {
        return "mountain{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", height=" + height +
                '}';
    }
}
