package com.ifmo.jjd.lesson9.flowershop;

import java.util.Arrays;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        FlowerShop shop = new FlowerShop();

        while (true) {
            System.out.println("Enter exit to quit.");
            String exit = input.next();
            if ("exit".equals(exit.toLowerCase())) break;
            for (int i = 0; i < 5; i++) {
                shop.addBouquet();
            }
            System.out.println(shop.toString());
            System.out.println("Wich bouquet you would like to sell? (input ID of bouquet)");
            int idToSell = input.nextInt();
            shop.sellBouquet(idToSell);
            shop.shopInfo();
        }
    }
}
