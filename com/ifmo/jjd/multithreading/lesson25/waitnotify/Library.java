package com.ifmo.jjd.multithreading.lesson25.waitnotify;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books = new ArrayList<>(6);

    public synchronized void putBook(Book book) throws InterruptedException {
        while(books.size() > 5) {
            System.out.println("put поток уходит в ожидание...");
            wait();
            // 1. Защита от произвольного пробуждения потока
            // 2. Если к моменту пробуждения условие, при котором поток должен ждать, все ещё выполняется
        }
        books.add(book);
        System.out.println("Книга добавлена. Всего книг: " + books.size());
        notify();
    }

    public synchronized Book getBook() throws InterruptedException {
        while (books.size() == 0){
            System.out.println("get уходит в ожидание");
            wait();
        }
        Book book = books.remove(0);
        System.out.println("Удалена книга, всего книг: " + books.size());
        notify();
        return book;
    }

}
// wait / notify вызываются либо в synchronized блоке, либо в synchronized методе (иначе - exception)
// putThread -> (добавляют не более 6 объектов, иначе - ждут) ->
// -> library: wait set [] ->
// getThread (если объектов в хранилище нет, поток ждет, пока они появятся

// у объекта есть сет wait set[] - сет для тех потоков, которые ждут

// wait() - приостанавливает работу потока до тех пор, пока поток не будет разбужен, например, вызовом метода notify
// notify() - необходимо разбудить один из потоков, который был успыплён у объекта.
//  Разбуженный поток передается "планировщику". Поток, который вызвал notify продолжит работу

// library: wait set [put1, put2]
// put1 -> library.wait()
// put2 -> library.wait()
// get1 -> library.notify()
// get2 -> library.notifyAll()
// put3 -> library.wait(1000) проснулся сам и ушёл к "планировщику",
//  т.к. не был разбужен методом notify() и прошло указанное в wait() количество милисекунд
// put4 -> library.wait() - проснулся сам, т.к. произошло случайное пробуждение потока
class Book {
}