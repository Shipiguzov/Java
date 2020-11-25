package com.ifmo.jjd.multithreading.lesson25.waitnotify;

public class PutThread implements Runnable{
    private Library library;

    public PutThread(Library library){
        this.library = library;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("put поток готовит данные для library");
            try {
                Thread.sleep((long)(Math.random() * 2000));
                library.putBook(new Book());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
