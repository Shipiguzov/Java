package com.ifmo.jjd.multithreading.lesson26.pizza;

import java.time.LocalDate;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class Waiter extends Human implements Runnable{

    ArrayBlockingQueue<Order> queueFromClients;
    LinkedBlockingQueue<Order> queueToChief;
    SynchronousQueue<Order> queueFromChief;

    public Waiter(String name, LocalDate birthDay, ArrayBlockingQueue<Order> queueFromClients, LinkedBlockingQueue<Order> queueToChief, SynchronousQueue<Order> queueFromChief) {
        super(name, birthDay);
        this.queueFromClients = queueFromClients;
        this.queueToChief = queueToChief;
        this.queueFromChief = queueFromChief;
    }

    private void takeOrderFromChiefQueue() throws InterruptedException {
        Order order = queueFromChief.take();
        System.out.println("Waiter " + this.name + " give order " + order + " from chief to client");
        Thread.sleep(3000);
    }

    private void moveOrderFromClientToChiefQueue() throws InterruptedException {
        Order order = queueFromClients.take();
        System.out.println("Waiter  " + this.name + " take order " + order + " from client's queue");
        Thread.sleep(3000);
        queueToChief.put(order);
        System.out.println("Waiter  " + this.name + " put order " + order + " to chief queue");
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                this.moveOrderFromClientToChiefQueue();
                this.takeOrderFromChiefQueue();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
