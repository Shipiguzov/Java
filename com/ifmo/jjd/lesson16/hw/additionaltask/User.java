package com.ifmo.jjd.lesson16.hw.additionaltask;

import com.sun.jdi.ObjectReference;

import java.time.LocalDate;
import java.util.Objects;

public class User {

    private String name;
    private LocalDate dateOfBirth;
    private String city;
    private Sex sex;
    private int spending;
    private Role role;

    public User(String name, LocalDate dateOfBirth, String city, Sex sex) {
        this.setName(name);
        this.dateOfBirth = dateOfBirth;
        this.setCity(city);
        this.sex = sex;
    }

    public User(String name, LocalDate dateOfBirth, String city, Sex sex, int spending, Role role) {
        this.setName(name);
        this.dateOfBirth = dateOfBirth;
        this.setCity(city);
        this.sex = sex;
        this.setSpending(spending);
        this.role = role;
    }

    public void setName(String name) {
        if (Objects.isNull(name) || name.length() < 3) throw new IllegalArgumentException("Name must be more 3 chars");
        this.name = name;
    }

    public void setCity(String city) {
        if (Objects.isNull(city) || city.length() < 3) throw new IllegalArgumentException("City must be more 3 chars");
        this.city = city;
    }

    public void setSpending(int spending) {
        if (spending < 0) throw new IllegalArgumentException("Spending must be more or equal 0");
        this.spending = spending;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getCity() {
        return city;
    }

    public Sex getSex() {
        return sex;
    }

    public int getSpending() {
        return spending;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", city='" + city + '\'' +
                ", sex=" + sex +
                ", spending=" + spending +
                ", role=" + role +
                '}';
    }
}
