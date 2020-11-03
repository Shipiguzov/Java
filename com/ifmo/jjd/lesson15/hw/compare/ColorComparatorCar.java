package com.ifmo.jjd.lesson15.hw.compare;

import java.util.Comparator;

public class ColorComparatorCar implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        return o1.getColor().compareTo(o2.getColor());
    }
}
