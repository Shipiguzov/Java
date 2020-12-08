package com.ifmo.jjd.patterns.singleton;

// порождающий паттерн о том, как создавать объекты
// на всю программу должен быть только один экземпляр данного класса
// самый лучший - перечисления
// должен содержать приватный конструктор, static переменную, содержащую сам объект и static метод для создания экземпляра
// минусы:
// нельзя использовать такой вариант в многопоточных средах
// глобальный объект
// можно создать при помощи рефлексии
public class Singleton {

    private static Singleton instance; // обязательное
    private int num;

    private Singleton(int num){ // обязательный
        this.num = num;
    }

    // глобальная точка доступа к объекту (момент его создания)
    public static Singleton getInstance(int num) { // обязательный
        if (instance == null) {
            instance = new Singleton(num);
        }
        return instance;
    }
}


