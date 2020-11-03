package com.ifmo.jjd.lesson15.hw.compare;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class ComparingExample {
    public static void main(String[] args) {

        // сортировать по значениям свойств: price, color, brand
        Car blackOpel = new Car("black", "opel", 2000);
        Car redOpel = new Car("red", "opel", 2500);
        Car yellowMazda = new Car("yellow", "mazda", 3000);
        Car greenMazda = new Car("green", "mazda", 3000);

        Comparator<Car> carComparator = new PriceComparatorCars()
                .thenComparing(new ColorComparatorCar()
                .thenComparing(new BrandComparatorCar()));
        ArrayList<Car> cars = new ArrayList<>(10);
        cars.add(blackOpel);
        cars.add(redOpel);
        cars.add(yellowMazda);
        cars.add(greenMazda);
        cars.sort(carComparator);
        System.out.println(cars);
    }
}
