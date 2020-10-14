package com.ifmo.jjd.lesson6.garden;

public class Tree {
    private Apple[] apples = new Apple[10];
    private int ageOfTree;
    private int numbersOfApples;

    public Tree() {
    }

    public Tree(int ageOfTree) {
        this.setAgeOfTree(ageOfTree);
    }

    public int addTreeDay() {
        this.setAgeOfTree(this.ageOfTree + 1);
        int numberOfFallApples = 0;
        for (int i = 0; i < apples.length; i++) {
            if (this.apples[i] != null) {
                this.apples[i].addAppleDay();
                if (!this.apples[i].isOnTree()) numberOfFallApples += 1;
            } else break;
        }

        //удаление упавших яблок
        for (int i = 0; i < numberOfFallApples; i++) {
            for (int j = apples.length; j < 1; j++) {
                if (apples[j] == null) {
                    apples[j-1] = null;
                    break;
                }
            }
        }

        // проверка на необходимость добавления новых яблок
        if (ageOfTree % 30 == 0) {
            Apple apple = new Apple(0);
            this.setApples(apple);
        }
        return numberOfFallApples;
    }

    public void setAgeOfTree(int ageOfTree) {
        if (ageOfTree < 0) throw new IllegalArgumentException("age must be 0 or more");
        this.ageOfTree = ageOfTree;
    }

    public Apple[] getApples() {
        return apples;
    }

    public void setApples(Apple... apples) {
        int applesOnTree = 0;
        for (int i = 0; i < apples.length; i++) {
            for (int j = 0; j < this.apples.length; j++) {
                if (this.apples[j] == null) {
                    this.apples[j] = apples[i];
                    applesOnTree += 1;
                    break;
                } else {
                    if (j == this.apples.length) {
                        System.out.println("Превышено максимальное количество яблок. Было размещено только " + (apples.length - applesOnTree) + " яблок.");
                    }
                }
            }
        }
        this.setNumbersOfApples();
    }

    public void setNumbersOfApples() {
        int count = 0;
        for (int i = 0; i < apples.length; i++) {
            if (apples[i] != null) {
                count += 1;
            } else break;
        }
        this.numbersOfApples = count;
    }

    @Override
    public String toString() {
        return "Tree{" +
                //"apples=" + Arrays.toString(apples) +
                "numbers of apples =" + numbersOfApples +
                ", ageOfTree=" + ageOfTree +
                "}\n\n";
    }
}
