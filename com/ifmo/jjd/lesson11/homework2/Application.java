package com.ifmo.jjd.lesson11.homework2;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        Planets[] planets = Planets.values();
        for (Planets planet : planets) {
            System.out.println(planet + " " + Arrays.toString(planet.planetsInfo()));
        }
    }
}
