package com.ifmo.jjd.multithreading.lesson24;

import com.ifmo.jjd.lesson22.Course;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.CopyOnWriteArrayList;

public class Lesson24 {
    public static void main(String[] args) {
        // старт программы -> создание процесса в ОС ->
        // создание основного потока.
        // После создания основного потока можно запускать
        // дополнительные потоки, тогда инструкции процесса
        // будут выполняться параллельно

        // одно ядро процессора может обрабатывать только
        // один поток

        // Жизненный цикл потока:
        // 1. NEW - поток создан (создание объекта класса Thread)
        // 2. RUNNABLE - вызов метода start() у объекта Thread,
        // управление потоком передается 'планировщику потоков jvm'
        // (Thread Scheduler)
        // 3. RUNNING - поток запущен и начинает выполнять инструкции
        // время запуска потока определяет 'планировщик потоков'
        // 4. NON-RUNNING (TIME WAITING, WAITING, BLOCKED) - поток может
        // находиться в состоянии ожидания
        // 5. TERMINATED - поток завершает работу

        // Создание потока - создание экземпляра класса Thread
        // передача потока 'планировщику' - вызов метода start() у объекта Thread

        // Варианты описания ИНСТРУКЦИЙ потока:
        // #1. создать класс, который наследуется от класса Thread,
        // инструкции, которые должен выполнять поток описываются в методе
        // public void run();
        // #2. инструкции, которые должен выполнять поток описываются в методе
        // public void run() интерфейса Runnable (при этом набор инструкций
        // можно описать в лямбда или создать отдельный класс)
        // #3. воспользоваться возможностями пакета java.util.concurrent.*

        CopyOnWriteArrayList<Course> courses = new CopyOnWriteArrayList<>();

        // #1. создание потока
        Thread writer = new Writer(courses);
        writer.setName("WRITER");

        // передача потока 'планировщику'
        writer.start();

        // #2.1 создание потока
        Thread reader = new Thread(new Reader(courses));
        reader.start();

        // завершение программы произойдет, когда завершатся все потоки
        // основной поток завершится, когда выполнит все свои инструкции

        // #2.2
        Thread simpleTask = new Thread(()->{ // реализация метода run интерфейса Runnable
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                System.out.println(Thread.currentThread().getName() +
                        " прочитал курсы " +
                        Files.readAllLines(Paths.get("sources/lesson24.txt")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        simpleTask.setName("SIMPLE_TASK");
        simpleTask.start();


        // Установка приоритета потоку носит рекомендательный для 'планировщика'
        // характер

        Thread readerOne = new Thread(new Reader(courses)); // Thread-3
        Thread readerTwo = new Thread(new Reader(courses)); // Thread-4
        Thread readerThree = new Thread(new Reader(courses)); // Thread-5

        // по умолчанию у всех потоков приоритет - 5
        readerOne.setPriority(Thread.MAX_PRIORITY);
        readerTwo.setPriority(Thread.MIN_PRIORITY);
        readerThree.setPriority(7);

        readerOne.start();
        readerTwo.start();
        readerThree.start();
    }
}
