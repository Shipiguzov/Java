package com.ifmo.jjd.lesson17.homework.reflection;

import com.ifmo.jjd.lesson17.reflection.Message;
import com.ifmo.jjd.lesson17.reflection.TextMessage;
import com.ifmo.jjd.lesson6.Author;
import com.ifmo.jjd.lesson6.ColouringBook;
import com.ifmo.jjd.lesson6.ColouringShelf;
import com.ifmo.jjd.lesson7.farm.Animal;
import com.ifmo.jjd.lesson7.farm.Farm;
import com.ifmo.jjd.lesson7.farm.MakeLists;
import com.ifmo.jjd.lesson7.farm.WildAnimal;

public class ReflectionApp {
    public static void main(String[] args) {

        //создание и заполнение объектами для работы программы (пока что так)
        WildAnimal wildAnimal = new WildAnimal("wolf", 100, 4, 20);
        Animal animal = new Animal("fox", 1, 1);
        ColouringShelf shelf = new ColouringShelf(10);
        ColouringBook dogs = new ColouringBook();
        ColouringBook flowers = new ColouringBook();
        Author author1 = new Author("Ivan", "Petrov");
        Author author2 = new Author("Alex", "Sidorov");
        dogs.setTitle("Собаки");
        dogs.setPageCount(28);
        dogs.setAuthor(author1);
        flowers.setTitle("Цветы");
        flowers.setPageCount(154);
        flowers.setAuthor(author2);
        shelf.addColouringBook(dogs, flowers, dogs, dogs, dogs, dogs, flowers);
        Integer[] arrayInt = {1, 5, 3, 6, 7};
        TextMessage textMessage = new TextMessage("Bla-bla-bla");
        System.out.println("------------------------------------------------------");
        try {
            System.out.println(ReflectionGetFields.toStringFields(shelf));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
