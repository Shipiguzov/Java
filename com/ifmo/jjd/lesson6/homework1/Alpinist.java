package com.ifmo.jjd.lesson6.homework1;

import java.util.Scanner;

public class Alpinist {
    private String name;
    private String adress;

    public Alpinist(){}

    public Alpinist(String name) {
        this.name = name;
    }

    public Alpinist(String name, String adress) {
        this.setName(name);
        this.setAdress(adress);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() < 2) {
            throw new IllegalArgumentException("Имя должно быть не менее 3 букв");
        }
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        if (adress == null || adress.length() < 4) {
            throw new IllegalArgumentException("Адресс должен быть не менее 5 символов");
        }
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "alpinist{" +
                "name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
}
