package com.ifmo.jjd.lesson6.homework1;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int numberOfAlpinists;
        /*String nameOfAlpinist;
        String adressOfAlpinist;*/



        // Group1
        System.out.println("Enter number of alpinists in first group");
        numberOfAlpinists = input.nextInt();
        Group group1 = new Group(numberOfAlpinists);
        /* I don't know why it doesn't works...
        for (int i = 0; i < group1.getAlpinistsCount(); i++) {
            System.out.print("Enter alpinist's name: ");
            nameOfAlpinist = input.nextLine();
            System.out.print("Enter aplinist's adress: ");
            adressOfAlpinist = input.nextLine();
            System.out.println(nameOfAlpinist + " " + adressOfAlpinist);
            Alpinist alpinist = new Alpinist(nameOfAlpinist.toString(), adressOfAlpinist.toString());
            group1.setListOfAlpinists(alpinist);
        }*/
        // Enter alpinists info
        for (int i = 0; i < group1.getAlpinistsCount(); i++) {
            StringBuilder nameOfAlpinist = new StringBuilder();
            StringBuilder adressOfAlpinist = new StringBuilder();
            nameOfAlpinist = nameOfAlpinist.append("Ivan Prtrov ").append(i);
            adressOfAlpinist = adressOfAlpinist.append("Moskow ").append(i);
            Alpinist alpinist = new Alpinist(nameOfAlpinist.toString(), adressOfAlpinist.toString());
            group1.setListOfAlpinists(alpinist);
        }
        int count = 0;
        for (int i = 0; i < group1.getListOfAlpinists().length; i++) {
            if (group1.getListOfAlpinists()[i] != null) count += 1;
        }
        if (count == numberOfAlpinists) group1.setIsfull(true);

        // Enter a mountain info
        String mountanName, mountainCountry;
        int mountainHeight;
        /*System.out.print("Enter mountain's name: ");
        mountanName = input.nextLine();
        System.out.print("Enter mountain's country: ");
        mountainCountry = input.nextLine();
        System.out.print("Enter height of the " + mountanName + ": ");
        mountainHeight = input.nextByte();*/
        mountanName = "Abra";
        mountainCountry = "Kadabra";
        mountainHeight = 900;
        Mountain mountain = new Mountain(mountanName, mountainCountry, mountainHeight);
        group1.setMountain(mountain);

        System.out.println(group1.toString());

        //Group2
        numberOfAlpinists = 2;
        Group group2 = new Group(numberOfAlpinists);
        for (int i = 0; i < group2.getAlpinistsCount(); i++) {
            StringBuilder nameOfAlpinist = new StringBuilder();
            StringBuilder adressOfAlpinist = new StringBuilder();
            nameOfAlpinist = nameOfAlpinist.append("Vasya Pupkin ").append(i);
            adressOfAlpinist = adressOfAlpinist.append("Saint-Petersburg ").append(i);
            Alpinist alpinist = new Alpinist(nameOfAlpinist.toString(), adressOfAlpinist.toString());
            group2.setListOfAlpinists(alpinist);
        }
        group2.setIsfull(true);
        mountanName = "qqqq";
        mountainCountry = "wqeqwewq";
        mountainHeight = 5430;
        mountain = new Mountain(mountanName, mountainCountry, mountainHeight);
        group2.setMountain(mountain);

        System.out.println(group2.toString());

        //group3
        System.out.print("Enter number of alpinists: ");
        numberOfAlpinists = input.nextInt();
        Group group3 = new Group(numberOfAlpinists);
        for (int i = 0; i < group3.getAlpinistsCount(); i++) {
            StringBuilder nameOfAlpinist = new StringBuilder();
            StringBuilder adressOfAlpinist = new StringBuilder();
            nameOfAlpinist = nameOfAlpinist.append("Alex Alex ").append(i);
            adressOfAlpinist = adressOfAlpinist.append("Perm ").append(i);
            Alpinist alpinist = new Alpinist(nameOfAlpinist.toString(), adressOfAlpinist.toString());
            group3.setListOfAlpinists(alpinist);
        }
        mountain = new Mountain("qazwsx1", "France", 2453);
        group3.setMountain(mountain);

        group3.setIsfull(true);

        System.out.println(group3.toString());
    }
}
