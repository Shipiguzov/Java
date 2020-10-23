package com.ifmo.jjd.objectsclasses;

public class Bucket {
    private Flower buk[] = new Flower[5];

    public void addFlower(Flower flower){
        for (int i = 0; i < buk.length; i++) {
            if (buk[i] == null) buk[i] = flower;
        }
    }

    public int getPrice(){
        int sum = 0;
        for (int i = 0; i < buk.length; i++) {
            if (buk[i] != null)
                sum += buk[i].getPrice();
        }
        return sum;
    }
    private static int count = 0;
    public void sellBuk(int money){
        if (money >= getPrice()){
            System.out.println("Букет продан");
            count++;
        }
        else System.out.println("Пшел вон");

    }
    public static int getCount(){
        return count;
    }



}
