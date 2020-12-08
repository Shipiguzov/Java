package com.ifmo.jjd.patterns;

import java.util.concurrent.Executors;

public class NutritionFacts {
    // обязательные параметры
    private final int servings;
    // необязательные параметры (со значениями по умолчанию)
    private final int calories;
    private final int fat;

    public static class Builder {
        // обязательные параметры
        private final int servings;

        // необязательные параметры (со значениями по умолчанию)
        private int calories = 1;
        private int fat = 1;

        // значения обязательных параметров передаем в конструктор
        public Builder(int servings) {
            this.servings = servings;
        }

        // для остальных свойств значения устанавливаются через сеттеры

        public Builder calories(int calories) {
            this.calories = calories;
            return this;
        }

        public Builder fat(int fat) {
            this.fat = fat;
            return this;
        }

        public NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder){
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
    }
}


