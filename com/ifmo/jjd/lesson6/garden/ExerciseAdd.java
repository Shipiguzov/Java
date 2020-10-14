package com.ifmo.jjd.lesson6.garden;

public class ExerciseAdd {
    public static void main(String[] args) {

        int countOfTrees = 3, applesOnEachTree = 5;
        int minCreationAgeOfApple = 25, maxCreationAgeOfApple = 30;
        int minRangeAgeOfTree = 25, maxRangeAgeOfTree = 30;
        Garden garden = new Garden();
        Tree[] treesInGarden = new Tree[countOfTrees];
        int freshAppleOnGround = 0, rottenAppleOnGround = 0;

        // создание treesInGarden со случайным возврастом каждого дерева
        for (int i = 0; i < countOfTrees; i++) {
            int ageOfTree = (int) (Math.random() * (maxRangeAgeOfTree - minRangeAgeOfTree + 1)) + minRangeAgeOfTree;
            treesInGarden[i] = new Tree(ageOfTree);
        }

        // добавление каждому дереву из treesInGarden случайного количество первоначальных яблок
        for (int i = 0; i < treesInGarden.length; i++) {
            int countApples = (int) (Math.random() * (applesOnEachTree));
            Apple[] applesOnTree = new Apple[countApples];
            for (int j = 0; j < applesOnTree.length; j++) {
                applesOnTree[j] = new Apple((int)(Math.random() * (maxCreationAgeOfApple - minCreationAgeOfApple + 1)) + minCreationAgeOfApple);
            }
            treesInGarden[i].setApples(applesOnTree);
        }
        garden.setTreesInGarden(treesInGarden);
        System.out.println(garden.toString());

        // прибавка дней к саду
        for (int i = 0; i < 5; i++) {
            rottenAppleOnGround += freshAppleOnGround;
            freshAppleOnGround += garden.addDayInGarden();
            System.out.println("На земле лежит " + freshAppleOnGround + " свежих яблок и " + rottenAppleOnGround + " испорченных яблок");
        }
        System.out.println(garden.toString());
    }
}
