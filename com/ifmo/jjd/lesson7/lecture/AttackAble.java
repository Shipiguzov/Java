package com.ifmo.jjd.lesson7.lecture;

public interface AttackAble {
    // метод без реализации
    void attack(BattleUnit unit);

    // метод с реализацией
    default void run(){
        System.out.println("Run AttackAble");
    }
}
