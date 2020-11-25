package com.ifmo.jjd.multithreading.lesson25;

public class IncrementTask extends Thread{

    private final SomeAccount account;

    public IncrementTask(SomeAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // синхронизированный блок. Синхронизация осуществляется по объекту в ()
        // в синхронизированный блок помещают только те инструкции, которые должны быть
        // сделаны последовательно с объектом внутри блока (account)
        //synchronized (account) { // монитор захвачен
            account.upBalance(10);

        //} // монитор разблокирован

        // у каждого объекта есть монитор. Монитор может быть заблокированным каким-либо потоком, либо разблокированным
        // за каждую единицу времени только один поток может блокировать монитор объекта
        // если монитор заблокирован потоком, другие потоки не могут работать с данным объектом

    }
}
