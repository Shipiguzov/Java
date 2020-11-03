package com.ifmo.jjd.lesson15.hw.compare;

import java.util.Comparator;

public class BrandComparatorCar implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.getBrand().compareTo(o2.getBrand());
    }
}
