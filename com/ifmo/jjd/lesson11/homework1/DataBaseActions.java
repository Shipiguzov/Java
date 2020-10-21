package com.ifmo.jjd.lesson11.homework1;

public interface DataBaseActions {

    //Начало работы
    void run();

    //Ввод данных
    String input();

    // Обработка введенных с консоли данных
    User processingUser(String user);

    //Ввод данных в ДБ
    void addUser(User user);

    // Определение Position
    Position definitionOfPosition(char position);

    // Нахождение последнего не null элемента в массиве
    int findIndex(User[] array);
}
