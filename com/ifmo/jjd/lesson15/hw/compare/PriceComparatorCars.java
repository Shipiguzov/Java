package com.ifmo.jjd.lesson15.hw.compare;

import java.util.Comparator;

public class PriceComparatorCars implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return Integer.compare(o1.getPrice(), o2.getPrice());
    }
}
