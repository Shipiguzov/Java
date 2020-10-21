package com.ifmo.jjd.lesson7.lecture;

public class King extends Unit {
    private int gold = 600;
    private BattleUnit[] army = new BattleUnit[20];

    public King(int healthPoints, int agilityPoints) {
        super(healthPoints, agilityPoints);
    }

    public void plusGold(int gold) {
        if (gold <= 0) return;
        this.gold += gold;
    }

    public void minusGold(int gold) {
        if (gold > 0 || this.gold >= gold) this.gold -= gold;
    }

    public boolean isGold() {
        return gold > 0;
    }

    public void generateArmy() {
        // первые три - пехотинцы, остальные - рыцари
        // Объекты типа Infantry и Knight можно добаваить в массив BattleUnit[]
        // т.к. BattleUnit - их общий тип данных (благодоря наследованию)
        // при этом объектам внутри массива не будут доступны их собственные методы (уникальные для дочернего класса)
        // все переопределённые методы для дочернего класса будут доступны

        if (this.gold < 250) return;
        for (int i = 0; i < 2; i++) {
            army[i] = new Infantry(
                    (int) (Math.random() * 41) + 20,
                    (int) (Math.random() * 11) + 5,
                    (int) (Math.random() * 11) + 5);
        }
        for (int i = 3; i < army.length; i++) {
            army[i] = new Knigth(
                    (int) (Math.random() * 41) + 10,
                    (int) (Math.random() * 11) + 5,
                    (int) (Math.random() * 11) + 8);
        }
    }

    public void addUnits(){
        for (int i = 0; i < army.length; i++) {
            if (this.gold >= 20 && !army[i].isAlive()) {
                army[i] = new Knigth(
                        (int) (Math.random() * 41) + 10,
                        (int) (Math.random() * 11) + 5,
                        (int) (Math.random() * 11) + 8);
            }
            minusGold(20);
        }
    }
}
