package com.ifmo.jjd.lesson11.homework1;

import java.util.Arrays;
import java.util.Scanner;

public class DataBase implements DataBaseActions {

    User[] directorList = new User[10];
    User[] cleanerList = new User[10];
    User[] healerList = new User[10];
    User[] internList = new User[10];


    @Override
    public void run() {
        do {
            String inputString = this.input();
            if (inputString == null) {
                System.out.println("Application terminated.");
                break;
            }
            User user = this.processingUser(inputString);
            this.addUser(user);
            System.out.println("Director's list: " + Arrays.toString(directorList));
            System.out.println("Doctor's list: " + Arrays.toString(healerList));
            System.out.println("Intern's list: " + Arrays.toString(internList));
            System.out.println("Cleaner's list: " + Arrays.toString(cleanerList));
        } while (true);
    }

    @Override
    public String input() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter username, salary and first letter of position (or exit to exit): ");
        String user = input.nextLine();
        if ("exit".equalsIgnoreCase(user)) return null;
        if (user == null || user.trim().length() < 5) throw new IllegalArgumentException("Wrong users data");
        return user;
    }

    @Override
    public User processingUser(String user) {
        String[] userArray;
        userArray = user.split(" ");
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < userArray.length - 2; i++) {
            name.append(userArray[i]).append(" ");
        }
        Position position = definitionOfPosition(userArray[userArray.length - 1].toCharArray()[0]);
        if (position == null) throw new IllegalArgumentException("Position letter error");
        return new User(
                name.toString(),
                Integer.parseInt(userArray[userArray.length - 2]),
                position
        );
    }

    @Override
    public void addUser(User user) {
        int index;
        switch (user.getPosition()) {
            case DIRECTOR:
                index = this.findIndex(this.directorList);
                if (index < 0) {
                    System.out.println("Arrays of Directors is full.");
                    break;
                }
                directorList[index] = user.clone();
                break;
            case HEALER:
                index = this.findIndex(this.healerList);
                if (index < 0) {
                    System.out.println("Arrays of Doctors is full.");
                    break;
                }
                healerList[index] = user.clone();
                break;
            case INTERN:
                index = this.findIndex(this.internList);
                if (index < 0) {
                    System.out.println("Arrays of Interns is full.");
                    break;
                }
                internList[index] = user.clone();
                break;
            case CLEANER:
                index = this.findIndex(this.cleanerList);
                if (index < 0) {
                    System.out.println("Arrays of Cleaners is full.");
                    break;
                }
                cleanerList[index] = user.clone();
                break;
        }
    }

    @Override
    public Position definitionOfPosition(char position) {
        Position[] tempPosition = Position.values();
        for (Position pos : tempPosition) {
            if (pos.name().charAt(0) == position) return pos;
        }
        return null;
    }

    @Override
    public int findIndex(User[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) return i;
        }
        return -1;
    }
}
