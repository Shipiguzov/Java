package com.ifmo.jjd.lesson11.homework2;

public enum Planets {
    EARTH(100, 500, 40), MARS(80, 1000, 30), MERCURY(30, 100, 10), VENERA(50, 200, 30);
    private final int mass;
    private final int orbit;
    private final int radius;

    Planets(int mass, int orbit, int radius) {
        if (mass <= 0 || orbit <= 0 || radius <= 0) throw new IllegalArgumentException("Wrong mass, orbit or radius");
        this.mass = mass;
        this.orbit = orbit;
        this.radius = radius;
    }

    public int getMass() {
        return mass;
    }

    public int getOrbit() {
        return orbit;
    }

    public int getRadius() {
        return radius;
    }

    public String[] planetsInfo() {
        return new String[] {" mass = " + this.mass, "orbit = " + this.orbit, "radus = " + this.radius};
    }
}
