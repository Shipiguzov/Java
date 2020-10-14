package com.ifmo.jjd.lesson9;

import java.util.Objects;

public class App {
    public static void main(String[] args) {
        Author ivan = new Author("Иван", "Петров");
        Author anna = new Author("Анна", "Гришкова");

        ColouringBook cars = new ColouringBook("Машинки", 23, 15);
        cars.setAuthor(ivan);

        ColouringBook robots = new ColouringBook("Роботы", 38, 19);
        robots.setAuthor(ivan);

        ColouringBook flowers = new ColouringBook("Цветы", 12, 10);
        flowers.setAuthor(anna);

        //Все классы наследуются от класса Object
        Object obj = new Object();
        Object author = new Author("Иван", "Петров");

        //toString()
        System.out.println(flowers.toString());

        //equals() и hashCode() исользуются для сравнения объектов

        Author author1 = new Author("Михаил", "Петров");
        Author author2 = new Author("Михаил", "Петров");
        // == сравнивает ссылки на объект и вернёт true, если
        System.out.println(author1 == author2); //false
        //метод equals() используется для сравнения объектов
        //equals() по умолчанию сравнивает ссылки на объект
        System.out.println(author1.equals(author2)); //true
        //instanceof проверяет принадлежность объекта к указанному типу

        //equals()
        //1. объект всегда равен самому себе (рефлективность)
        //2. если a.equals(b), то и b.equals(a) (симметричность)
        //3. если a.equals(b), и b.equals(c), то и a.equals(c) (транзитивность)
        //4. сколько бы раз не вызывался equals без изменения состояния объекта, результат должен оставаться неизменным (консистентноть)
        //hashCode()
        //hashCode - не адрес в памяти
        //1. если объекты равны по equals, то hashCode должен вернуть одинаковое значание для обоих объектов
        //2. если объекты не равны по equals, то hashCode может верныть одинаковое значение для обоих объектов
        //3. если состояние объекта не именяется, то hashCode должен возвращать одинаковый результат
        System.out.println(author1.hashCode());
        System.out.println(author2.hashCode());

        ColouringBook colouring1 = new ColouringBook("Роботы", 38, 19);
        colouring1.setAuthor(ivan);

        ColouringBook colouring2 = new ColouringBook("Роботы", 38, 19);
        colouring2.setAuthor(ivan);

        System.out.println(colouring1.equals(colouring2));//false
        //Objects.hash(picCount) - вернет hashCode объекта

        //clone()
        //модификатор доступа - protected
        //возвращает Object
        //super.clone() - не создаёт копии объектов
        //super.clone() обязывет метод выбрасывать CloneNotSupportedException, но нужно будет написать свою реализацию
        //(создание нового объекта)
        ColouringBook cloneColouting = colouring1;
        ivan = new Author("Иван", "Петров");
        //Author copyIvan = ivan.clone();
        ColouringBook cloneColouring = colouring1.clone();
        System.out.println(cloneColouring == colouring1);

        //класс Objects - набор статических методов для работы с объектами
        //Objects.requireNonNull(null, "Is NULL");
        //Objects.requireNonNull(null);
    }
}