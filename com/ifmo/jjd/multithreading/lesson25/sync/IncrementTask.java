package com.ifmo.jjd.multithreading.lesson25.sync;



public class IncrementTask extends Thread{
    private final SomeAccount account;

    public IncrementTask(SomeAccount account){
        this.account = account;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // операции не связанные с объектом account должны быть вынесены
        // за synchronized блок
        //synchronized (account){ // монитор захвачен
            account.upBalance(10);
        //} // монитор разблокирован

        // obj - monitor lock / unlock
        // в одну ед времени только один поток может блокировать монитор объекта
        // если монитор объекта заблокирован потоком другие потоки не могут
        // работать с этим объектом


    }
}
