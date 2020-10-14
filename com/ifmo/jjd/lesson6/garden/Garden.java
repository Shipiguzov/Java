package com.ifmo.jjd.lesson6.garden;

import java.util.Arrays;

public class Garden {
    private Tree[] treesInGarden = new Tree[20];
    private int ageOfGarden = 0;

    public Tree[] getTreesInGarden() {
        return treesInGarden;
    }

    public int addDayInGarden() {
        int numberOfFallApple = 0;
        for (int i = 0; i < treesInGarden.length; i++) {
            if (this.treesInGarden[i] != null) {
                numberOfFallApple += this.treesInGarden[i].addTreeDay();
            } else break;
        }
        setAgeOfGarden(1);
        return numberOfFallApple;
    }

    public void setTreesInGarden(Tree... treesInGarden) {
        int addTreesInGarden = 0;
        int count = 0;
        while (this.treesInGarden[count] != null) {
            count += 1;
        }
        for (int i = 0; i < treesInGarden.length; i++) {
            if (count == this.treesInGarden.length) {
                System.out.println("В саду нету места для новых деревьев. Было добавлено " + (addTreesInGarden) + " вместо " + treesInGarden.length);
                return;
            }
            this.treesInGarden[count] = treesInGarden[i];
            addTreesInGarden += 1;
            count += 1;
        }
    }

    public int getAgeOfGarden() {
        return ageOfGarden;
    }

    public void setAgeOfGarden(int ageOfGarden) {
        if (ageOfGarden < 0) throw new IllegalArgumentException("ageOfGarden must be 0 or more");
        this.ageOfGarden = this.ageOfGarden + ageOfGarden;
    }

    @Override
    public String toString() {
        return "Garden{" +
                "treesInGarden=" + Arrays.toString(treesInGarden) +
                ", ageOfGarden=" + ageOfGarden +
                '}';
    }
}
