package com.ifmo.jjd.lesson7.farm;

public class WildAnimal
        extends Animal
        implements WildAnimalActions {

    private int strength;
    private int fear;
    private boolean atackOnFarmInThisDay = true;

    public WildAnimal(String name, int weight, int speed, int strength) {
        super(name, weight, speed);
        this.setStrength(strength);
    }

    public void setStrength(int strength) {
        if (strength < 1) throw new IllegalArgumentException("strength < 1");
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public void attackOnFarmAnimal(FarmAnimal animal) {
        if (!animal.runFromWildAnimal(this)) {
            System.out.println(this.getName() + " atacked " + animal.getName());
            animal.takeWounds(this.strength);
        }
    }

    @Override
    public void takeFear() {
        this.atackOnFarmInThisDay = false;
        this.fear++;
    }

    @Override
    public boolean isAttackOnFarm() {
        if (!atackOnFarmInThisDay) {
            this.atackOnFarmInThisDay = true;
            return false;
        }
        if (this.fear > 3) {
            this.fear = 0;
            this.atackOnFarmInThisDay = true;
            System.out.println(this.getName() + " feared.");
            return false;
        }
        return true;
    }
}
