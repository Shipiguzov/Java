package com.ifmo.jjd.multithreading.lesson24;

import com.ifmo.jjd.lesson22.Course;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.CopyOnWriteArrayList;

public class Writer extends Thread{
    private CopyOnWriteArrayList<Course> courses;
    private BufferedReader reader;

    public Writer(CopyOnWriteArrayList<Course> courses) {
        this.courses = courses;
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override // в методе run описываются инструкции потока, метод
    public void run() { // вызывается при запуске потока (RUNNING)
        while (true) {
            try {
                // Thread.currentThread() - ссылка на текущий поток
                // getName() - возвращает имя потока
                System.out.println("Поток " + Thread.currentThread().getName());
                System.out.println("Введите название курса");
                String name = reader.readLine();
                System.out.println("Введите продолжительность курса");
                int duration = Integer.parseInt(reader.readLine());
                System.out.println("Введите стоимость курса");
                int price = Integer.parseInt(reader.readLine());
                // добавит объект, переданный в конец списка, если элемент отсутствует
                if (courses.addIfAbsent(new Course(name, duration, price))) {
                    System.out.println("Курс успешно добавлен");
                } else {
                    System.out.println("Курс не был добавлен");
                }
            } catch (IOException | NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
}
