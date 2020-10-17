package com.ifmo.jjd.lesson9.flowershop;

public class Service {
    public static int randomNumber(int minRange, int maxRange) {
        return (int) (Math.random() * (maxRange - minRange + 1)) + minRange;
    }

    //public Flower(String name, String country, int price, int storageDays) {
    public static Flower flower(int number) {
        switch (number) {
            case 0: return new Flower(
                    "Роза",
                    "Россия",
                    100,
                    3
            );
            case 1: return new Flower(
                    "Гвоздика",
                    "Белорусь",
                    40,
                    5
            );
            case 2: return new Flower(
                    "Тюльпан",
                    "Голландия",
                    30,
                    3
            );
            case 3: return new Flower(
                    "Пион",
                    "Россия",
                    70,
                    4
            );
            case 4: return new Flower(
                    "Ромашка",
                    "Украина",
                    20,
                    5
            );
        }
        throw new IllegalArgumentException("index flower out of range");
    }

    public static String bouquetName(){
        int number = Service.randomNumber(0, 5);
        switch (number) {
            case 0: return "Classic";
            case 1: return "Pleasure";
            case 2: return "Nice";
            case 3: return "Beautiful";
            case 4: return "Luxury";
            case 5: return "Simple";
        }
        throw new IllegalArgumentException("index name of bouquet out of range");
    }
}
