package com.ifmo.jjd.lesson7;

public class Knight extends BattleUnit{
    private final int additionalAttack = 2;

    public Knight(int healthPoints, int agilityPoints, int attackPoints) {
        super(healthPoints, agilityPoints, attackPoints);
    }

    @Override
    public void attack(BattleUnit unit) {
        if (this.isAlive() && unit.isAlive() && this.agilityPoints >= unit.agilityPoints)
            unit.minusHealth(this.attackPoints + additionalAttack);
        if (unit.isAlive() && this.isAlive() && unit.agilityPoints >= this.agilityPoints)
            this.minusHealth(unit.attackPoints);
    }

    @Override
    public void rest() {
        plusHealth(3);
    }
}

