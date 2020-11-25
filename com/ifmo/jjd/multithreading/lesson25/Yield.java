package com.ifmo.jjd.multithreading.lesson25;

public class Yield {
    public static void main(String[] args) {

        Runnable task = ()->{
            while (true) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread());
                //
                Thread.yield();
            }
        };

        new Thread(task).start();
        new Thread(task).start();

    }
}
