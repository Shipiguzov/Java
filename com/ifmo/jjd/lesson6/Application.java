package com.ifmo.jjd.lesson6;

import java.util.concurrent.CountDownLatch;

// com.ifmo.jjd.lesson6.Application - полное имя класса
public class Application {
    public static void main(String[] args) {
        // создание объекта
        // тип_данных имя_переменной = new коструктор();
        // создание объекта типа ColouringBook
        ColouringBook dogs = new ColouringBook();
        ColouringBook flowers = new ColouringBook();

        // обращение к свойству
        // dogs.title = "Собаки";
        // может быть не корректное значение свойств
        // это может навредить программе, например.
        // dogs.title = ""; dogs.title = null;
        // поэтому лучше ограничить доступ к свойству

        dogs.setTitle("Собаки");
        flowers.setTitle("Цветы");

        String dogsTitle = dogs.getTitle();
        System.out.println(dogsTitle);
        System.out.println(flowers.getTitle());

        Author ivan = new Author("Иван");
        //ivan.setName("Иван");
        ivan.setSurname("Петров");

        dogs.setAuthor(ivan);
        // dogs.getAuthor() -> объект Author
        System.out.println(dogs.getAuthor().getFullName());

        System.out.println(dogs);

        ColouringShelf shelf = new ColouringShelf(11, "white");
        System.out.println(shelf);

        shelf.addColouringBook(dogs);
        shelf.addColouringBook(flowers);

        shelf.addColouringBook(dogs, flowers);

        System.out.println(shelf.getBookInfo());



    }
}
