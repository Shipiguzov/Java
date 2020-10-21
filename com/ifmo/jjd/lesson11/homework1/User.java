package com.ifmo.jjd.lesson11.homework1;

import java.util.Objects;

public class User {
    private final String name;
    private int salary;
    private Position position;

    public User(String name, int salary, Position position) {
        if (name == null || name.trim().length() < 5) throw new IllegalArgumentException("Wrong name of user");
        this.name = name;
        this.setSalary(salary);
        this.setPosition(position);
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setSalary(int salary) {
        if (salary <= 0) throw new IllegalArgumentException("salary <= 0");
        this.salary = salary;
    }

    public void setPosition(Position position) {
        Objects.requireNonNull(position, "position == null");
        this.position = position;
    }

    @Override
    protected User clone() {
        return new User(
                this.name,
                this.salary,
                this.position
        );
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", position=" + position +
                '}';
    }
}
