package com.ifmo.jjd.exam1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String wishZone;
        int numberOfAboniment;
        Fitness fitness = new Fitness();
        //Abonnement currentAbonnement;

        // Заполняем массив абонементов случайными абонементами
        for (int i = 0; i < Logger.random(50, 100); i++) {
            fitness.addAboniment();
        }
        LocalTime currentTime = Logger.getCurrentDateTime().toLocalTime();
        LocalDate currentDate = Logger.getCurrentDateTime().toLocalDate();
        System.out.println(fitness.toString());

        // Основное тело программы
        do {
            // проверка работает ли фитнес во время currentTime
            if (!fitness.fitnessWork(currentTime)) {
                System.out.println("Fitness not work in " + currentTime.toString());
                break;
            }

            System.out.println("Do you want to see information about zones? (1 - for yes, 0 - for no)");
            numberOfAboniment = input.nextInt();
            if (numberOfAboniment == 1) fitness.fitnessInfo();

            // Ввод номера абонимента
            System.out.println("Enter abonnement number: (or -1 for exit)");
            numberOfAboniment = input.nextInt();
            if (numberOfAboniment < 0) break;
            System.out.println("Current abonimens: \n" + fitness.getAboniment(numberOfAboniment).toString());
            System.out.println("Date of visit: " + Logger.getCurrentDateTime());

            //currentAboniment = fitness.getAboniment(numberOfAboniment).clone();
            if (fitness.getAboniment(numberOfAboniment) == null) {
                System.out.println("Aboniment № " + numberOfAboniment + "didn't registred.");
                continue;
            }

            // Проверка действует ли абонимент
            if (fitness.abonimentExpired(fitness.getAboniment(numberOfAboniment), currentDate)) {
                System.out.println("Sorry but your aboniment has expired. You can buy another one.");
                continue;
            }

            // Ввод желаемой зоны
            do {
                System.out.println("Enter name of the zone (pool, gym, group):");
                wishZone = input.next().trim().toLowerCase();
            } while (!"pool".equals(wishZone) && !"gym".equals(wishZone) && !"group".equals(wishZone));

            // Проверка может ли абонемент войти в зону, которую хочет
            if (!fitness.accessToZone(fitness.getAboniment(numberOfAboniment), wishZone)) continue;

            // Добавление абонемента в зону
            if (fitness.abonimentInZones(numberOfAboniment)) {
                System.out.println("Abonnement is aready in zone");
                continue;
            }
            if (!fitness.addAbonnentToZone(numberOfAboniment, wishZone)) {
                System.out.println("Zone " + wishZone + "is full");
                continue;
            }

        } while (numberOfAboniment >= 0);
    }
}
