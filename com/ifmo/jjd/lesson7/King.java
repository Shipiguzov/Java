package com.ifmo.jjd.lesson7;

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
//        if (gold <= 0) return;
//        if (hasGold()) {
//            this.gold -= gold;
//            if (!hasGold()) this.gold = 0;
//        }

        if (gold > 0 || this.gold >= gold) this.gold -= gold;

    }

    public boolean hasGold() {
        return gold > 0;
    }

    public void generateArmy() {
        // объекты типа Infantry и Knight можно добавить в массив BattleUnit[],
        // тк BattleUnit - их общий тип данных (благодаря наследованию)
        // при этом объектам внутри массива не будут доступны их собственные методы
        // Все переопределенные методы будут доступны
        if (this.gold < Price.ARMY) return;
        for (int i = 0; i < army.length; i++) {
            army[i] = BattleUnit.unitFactory();
        }

        minusGold(Price.ARMY);
    }

    public void addUnits() {
        for (int i = 0; i < army.length; i++) {
            if (this.gold >= Price.UNIT && !army[i].isAlive()) {
                army[i] = BattleUnit.unitFactory();
                minusGold(Price.UNIT);
            }
        }
    }

    public void startAttack(King enemy){
        for (int i = 0; i < this.army.length; i++) {
            // если army[i] - объект типа Knight, то будет вызван метод
            // attack реализованный классе Knight
            // если army[i] - объект типа Infantry, то будет вызван метод
            // attack реализованный классе Infantry
            army[i].attack(enemy.army[(int) (Math.random() * enemy.army.length)]);
            army[i].rest();
        }
    }

    public int getAttackResult(){
        int alive = 0;
        for (BattleUnit unit: army) {
            if (unit.isAlive()) alive++;
        }
        return alive;
    }

    @Override
    public void rest() {
        minusGold(20);
    }
}
