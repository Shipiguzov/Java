package com.ifmo.jjd.lesson13.generic.methods;

public class TstGenericMethods {
    public static void main(String[] args) {

        String[] strings = {"qwe", "asd", "xzc"};
        String elem = "qwe";

        Integer[] integers = {45, 67, 89};
        Integer intVar = 34;

        System.out.println(CustomUtils.inArray(strings, elem));
        System.out.println(CustomUtils.inArray(integers, intVar));

        Double doubleVar = 3.14;
        System.out.println(CustomUtils.<Integer, Double>compareHashCode(intVar, doubleVar));
        // System.out.println(CustomUtils.<Integer, Integer>compareHashCode(intVar, doubleVar));

    }
}
