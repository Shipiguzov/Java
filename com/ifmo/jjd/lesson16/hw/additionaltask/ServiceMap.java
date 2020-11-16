package com.ifmo.jjd.lesson16.hw.additionaltask;

import java.time.LocalDate;
import java.util.Random;

public class ServiceMap {

    public static User randomUser() {
        StringBuilder randomName = new StringBuilder();
        String[] manNames = {"Alex", "Ivan", "Vlad"};
        String[] surnames = {"Ivanov", "Petrov", "Sidorov"};
        String[] femaleNames = {"Anna", "Ksuhsa", "Nastya"};
        String[] cities = {"Moskow", "Spb", "Ekaterinburg"};
        Random randomNumber = new Random();
        LocalDate dateOfBirth;
        Role[] roles = {Role.NEW, Role.OFTEN, Role.SELDOM};
        Sex sex;

        if (randomNumber.nextBoolean()) sex = Sex.MAN;
        else sex = Sex.FEMALE;

        if (sex == Sex.FEMALE)
            randomName
                    .append(femaleNames[randomNumber.nextInt(3)])
                    .append(" ")
                    .append(surnames[randomNumber.nextInt(3)])
                    .append("a");
        else randomName
                .append(manNames[randomNumber.nextInt(3)])
                .append(" ")
                .append(surnames[randomNumber.nextInt(3)]);

        dateOfBirth = LocalDate.of(1980 + randomNumber.nextInt(20), randomNumber.nextInt(11) + 1, randomNumber.nextInt(27) + 1);
        String city = cities[randomNumber.nextInt(3)];
        Role role = roles[randomNumber.nextInt(3)];
        int spending = randomNumber.nextInt(1000);
        //public User(String name, LocalDate dateOfBirth, String city, Sex sex, int spending, Role role) {
        return new User(randomName.toString(), dateOfBirth, city, sex, spending, role);
    }
}
