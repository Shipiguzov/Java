package com.ifmo.jjd.lesson13.generic.bounded.type.parameters;

public class TstGarage {
    public static void main(String[] args) {
        Bus bus = new Bus("Спб", "Тверь", "234", false);
        Train train = new Train("Спб", "Москва", "23-Ф", 12);

        // тип поля carOnService объекта garage1 - Bus!
        Garage<Bus> garage1 = new Garage<>();
        garage1.setCarOnService(bus);
        // метод isWiFi доступен, потому что мы определили так в generic
        System.out.println(garage1.getCarOnService().isWiFi());

        // тип поля carOnService объекта garage2 - Transport!
        Garage<Transport> garage2 = new Garage<>();
        // Bus становится Transport. на строчке 20 - приведение классов и он опять становится Bus
        garage2.setCarOnService(bus);
        // Если при приведении типов стираются поля, то они продолжают хранится в памяти и потом можно
        // воспользоваться приведением типов. Тогда поля восстановятся обратно.
        bus = (Bus) garage2.getCarOnService();


    }
}