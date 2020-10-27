package com.ifmo.jjd.lesson13.generic.bounded.type.parameters;

public class CustomGarage extends Garage{
    // public class CustomGarage extends Garage{ - значение carOnService - Transport,
    // т.к. он указан в классе Garage<T extends Transport & Repairing>

    public void checkItem() {
        System.out.println(this.getCarOnService().getNum());
    }
}

class CustomGarage2 extends Garage<Transport> {
    // public class CustomGarage extends Garage{ - значение carOnService - Transport,
    // т.к. он указан в классе CustomGarage2 extends Garage<Transport>
    public void checkItem() {
        System.out.println(this.getCarOnService().getNum());
    }
}

class CustomGarage3 extends Garage<Bus> {
    // public class CustomGarage extends Garage{ - значение carOnService - Bus,
    // т.к. он указан в классе CustomGarage3 extends Garage<Bus>
    public void checkItem() {
        System.out.println(this.getCarOnService().isWiFi());
    }
}
