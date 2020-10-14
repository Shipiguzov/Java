package com.ifmo.jjd.lesson7.farm;

final public class MakeLists {

    final public static FarmAnimal chooseFarmAnimal() {
        switch (Farm.randomNumber(1, 4)) {
            case 1:
                return new FarmAnimal(
                        "cat",
                        Farm.randomNumber(3, 4),
                        Farm.randomNumber(2, 3),
                        Farm.randomNumber(2, 3),
                        0,
                        false
                );
            case 2:
                return new FarmAnimal(
                        "chicken",
                        Farm.randomNumber(1, 3),
                        Farm.randomNumber(1, 3),
                        Farm.randomNumber(1, 2),
                        1,
                        true
                );
            case 3:
                return new FarmAnimal(
                        "rabbit",
                        Farm.randomNumber(3, 4),
                        Farm.randomNumber(3, 4),
                        Farm.randomNumber(1, 3),
                        0,
                        true
                );
            case 4:
                return new FarmAnimal(
                        "cow",
                        Farm.randomNumber(7, 10),
                        Farm.randomNumber(1, 2),
                        Farm.randomNumber(7, 10),
                        1,
                        true
                );
            default:
                return null;
        }
    }

    //public WildAnimal(String name, int weight, int speed, int strength)
    final public static WildAnimal chooseWildAnimal(int number) {
        if (number < 0 || number > 2) throw new IllegalArgumentException("number < 0 || number > 2");
        switch (number) {
            case 0:
                return new WildAnimal(
                        "wolf",
                        Farm.randomNumber(4, 6),
                        Farm.randomNumber(2, 3),
                        Farm.randomNumber(3, 5)
                );
            case 1:
                return new WildAnimal(
                        "fox",
                        Farm.randomNumber(2, 3),
                        Farm.randomNumber(3, 4),
                        Farm.randomNumber(2, 3)
                );
            case 2: return new WildAnimal(
                    "bear",
                    Farm.randomNumber(7, 10),
                    Farm.randomNumber(1, 3),
                    Farm.randomNumber(5, 8)
            );
            default: return null;
        }
    }
}
