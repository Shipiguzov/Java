package com.ifmo.jjd.patterns.builder;

import com.ifmo.jjd.patterns.NutritionFacts;

public class TstBuilder {
    public static void main(String[] args) {
        NutritionFacts apple = new NutritionFacts.Builder(3).calories(100).fat(5).build();
        System.out.println(apple);
    }
}
