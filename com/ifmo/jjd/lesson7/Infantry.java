package com.ifmo.jjd.lesson7;

public class Infantry extends BattleUnit{

    public Infantry(int healthPoints, int agilityPoints, int attackPoints) {
        super(healthPoints, agilityPoints, attackPoints);
    }
    // реализация метода attack(BattleUnit unit) интерфейса AttackAble
    @Override
    public void attack(BattleUnit unit) {
        if (this.isAlive() && unit.isAlive() && this.agilityPoints >= unit.agilityPoints)
            unit.minusHealth(this.attackPoints);
        if (unit.isAlive() && this.isAlive() && unit.agilityPoints >= this.agilityPoints)
            this.minusHealth(unit.attackPoints);
    }
    // реализация метода rest() интерфейса RestAble
    @Override
    public void rest() {
        this.plusHealth(2);
    }
}



