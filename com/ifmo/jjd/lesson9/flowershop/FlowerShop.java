package com.ifmo.jjd.lesson9.flowershop;

import java.util.Arrays;

public final class FlowerShop {
    private static int countOfSellBouquet = 0;
    private Bouquet[] bouquets = new Bouquet[5];
    private static int moneyInCashbox = 0;

    public void addBouquet(Bouquet bouquet) {
        int count = 0;
        if (bouquet == null) throw new IllegalArgumentException("bouquet == null");
        for (int i = 0; i < this.bouquets.length; i++) {
            if (this.bouquets[i] == null) {
                this.bouquets[i] = bouquet;
                break;
            }
            count++;
        }
        if (count == this.bouquets.length) System.out.println("Для нового букета нет места на полке");
    }

    private int indexBouquetOnShell(int bouquetID) {
        for (int i = 0; i < this.bouquets.length; i++) {
            if (this.bouquets[i].getId() == bouquetID) return i;
        }
        return -1;
    }

    public void sellBouquet(int bouquetID) {
        if (bouquetID < 0) throw new IllegalArgumentException("Wrong bouquetID");
        if (indexBouquetOnShell(bouquetID) < 0) throw new IllegalArgumentException("На полке в магазине нет букета " + bouquetID);
        this.moneyInCashbox += this.bouquets[indexBouquetOnShell(bouquetID)].getCost();
        this.countOfSellBouquet++;
        System.out.println("Был продан букет с ID " + bouquetID);
        this.bouquets[indexBouquetOnShell(bouquetID)] = null;
    }

    public void addBouquet() {
        int count = 0;
        for (int i = 0; i < this.bouquets.length; i++) {
            if (this.bouquets[i] == null) {
                this.bouquets[i] = new Bouquet(Service.bouquetName(), Service.randomNumber(0, 1000));
                for (int j = 0; j < Service.randomNumber(3, 5); j++) {
                    this.bouquets[i].addFlower();
                }
                this.bouquets[i].takeCost();
                this.bouquets[i].takeStorageDays();
                break;
            }
            count++;
        }
        //if (count == this.bouquets.length) System.out.println("На полке нет места для нового букета");
    }

    public void shopInfo() {
        System.out.println("Всего продано " + this.countOfSellBouquet);
        System.out.println("В кассе " + moneyInCashbox + " денег.");
    }

    @Override
    public String toString() {
        return "FlowerShop{" +
                "bouquets=" + Arrays.toString(bouquets) +
                '}';
    }
}
