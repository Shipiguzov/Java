package com.ifmo.jjd.lesson7.lecture;

public class Infantry extends BattleUnit{

    public Infantry(int healthPoints, int agilityPoints, int attakPoints) {
        super(healthPoints, agilityPoints, attakPoints);
    }

    // реализация метода attack(battleUnit unit) интерфейса AttackAble
    @Override
    public void attack(BattleUnit unit) {
        if (this.isAlive())
            if (this.agilityPoints >= unit.agilityPoints) unit.minusHealth(this.attakPoints);
        if (unit.isAlive())
            if (unit.agilityPoints >= this.agilityPoints) this.minusHealth(unit.attakPoints);
    }

    // реализация метода rest() интерфейса RestAble
    @Override
    public void rest() {
        this.plusHealth(2);
    }
}
