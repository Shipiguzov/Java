package com.ifmo.jjd.lesson22.compare;

import java.util.ArrayList;
import java.util.Comparator;

public class ComparingExample {
    public static void main(String[] args) {

        // сортировать по значениям свойств: price, color, brand
        Car blackOpel = new Car("black", "opel", 2000);
        Car redOpel = new Car("red", "opel", 2500);
        Car yellowMazda = new Car("yellow", "mazda", 3000);
        Car greenMazda = new Car("green", "mazda", 3000);

        ArrayList<Car> cars = new ArrayList<>(10);
        cars.add(blackOpel);
        cars.add(redOpel);
        cars.add(yellowMazda);
        cars.add(greenMazda);
        cars.sort(Comparator
                .comparing(Car::getPrice)
                .thenComparing(Car::getColor)
                .thenComparing(Car::getBrand)
        );
        System.out.println(cars);
    }
}
