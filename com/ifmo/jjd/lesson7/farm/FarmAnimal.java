package com.ifmo.jjd.lesson7.farm;

public class FarmAnimal
        extends Animal
        implements FarmAnimalActions {
    private int health;
    private int healthPoints;
    private int resources;
    private boolean alive = true;
    private boolean eatable;

    public FarmAnimal(String name, int weight, int speed, int health, int resources, boolean eatable) {
        super(name, weight, speed);
        this.setHealth(health);
        this.setResources(resources);
        this.healthPoints = this.health;
        this.eatable = eatable;
    }

    public boolean isEatable() {
        return eatable;
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return alive;
    }

    public int getResources() {
        return resources;
    }

    public void setResources(int resources) {
        if (resources < 0) throw new IllegalArgumentException("resources < 0");
        this.resources = resources;
    }

    public void setHealth(int health) {
        if (health < 1) throw new IllegalArgumentException("health < 1");
        this.health = health;
    }

    @Override
    public void takeWounds(int wounds) {
        this.healthPoints -= wounds;
        this.aliveCheck();
    }

    @Override
    public void aliveCheck() {
        if (this.healthPoints <= 0) {
            this.alive = false;
            System.out.println(this.getName() + " is dead.");
        }
    }

    @Override
    public void addHealthPoints(int hp) {
        if (this.healthPoints + hp < this.health) {
            this.healthPoints += hp;
        } else this.healthPoints = this.health;
    }

    @Override
    public boolean runFromWildAnimal(WildAnimal animal) {
        if (this.getSpeed() > animal.getSpeed()) {
            System.out.println(this.getName() + " run away from " + animal.getName());
            return true;
        }
        return false;
    }
}
