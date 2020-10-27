package com.ifmo.jjd.lesson13.generic.types;

public class TstGenericType {
    public static void main(String[] args) {
        // В <> указываем тип данных, который будет использоваться вместо T для данного объекта
        // если не куазать тип данных в <> при объявлении класса, то тип Т данных id будет по умолчанию - Object
        User<String> stringUser = new User<>();
        stringUser.setLogin("qwe");
        stringUser.setPwd("123");
        stringUser.setId("12afjgjsfds");

        String sId = stringUser.getId(); // String

        // Для данного объекта тип T, а соответственно и тип данных id будет Integer
        User<Integer> integerUser = new User<>();
        integerUser.setId(12);
        integerUser.setPwd("fdsaf21");
        Integer iId = integerUser.getId();

        // <T, K> T - key; K - value;
        // Для объекта container1 тип данных key - String, а тип данных value - Integer
        PairContainer<String, Integer> container1 = new PairContainer<>("qwe", 1);
        // Для объекта container2 тип данных key - String, а тип данных value - User (тип id - Object)
        PairContainer<String, User> container2 = new PairContainer<>("qwe", stringUser);
        Object oId = container2.getValue().getId(); // Object
        // Для объекта container3 тип данных key - String, а тип данных value - User (тип id - String)
        PairContainer<String, User<String>> container3 = new PairContainer<>("qwe", stringUser);
        sId = container3.getValue().getId(); // String

        User<Number> numberUser = new User<>();
        PairContainer<String, User<Number>> container4 = new PairContainer<>("asd", numberUser);


    }
}
