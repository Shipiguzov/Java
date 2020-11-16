package com.ifmo.jjd.lesson16.hw.additionaltask;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class MapTask {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            users.add(ServiceMap.randomUser());
        }
        System.out.println(users);
        System.out.println("Avarange age of users: " + getAverangeAge(users));
        System.out.println("Map<Sex, Averange Spend money: " + getSpendingMoneyWithSex(users));
        System.out.println("Map<City, Users>: " + getCityWithUsers(users));
        System.out.println("Map<Role, Users>: " + getRoleWithUsers(users));
        System.out.println("Map<yearOfBirth, Users>: " + getYearWithUsers(users));
        System.out.println("Sorted users by year if Birth: " + sortByYearOfBirth(users).toString());
        Role role = Role.OFTEN;
        System.out.println("Users with role " + role + ": " + newListByRole(users, role));
    }

    private static double getAverangeAge(List<User> users) {
        double result = 0;
        for (User user : users) {
            result += ChronoUnit.YEARS.between(user.getDateOfBirth(), LocalDate.now());
        }
        return result / users.size();
    }

    private static Map<Sex, Integer> getSpendingMoneyWithSex(List<User> users) {
        Map<Sex, Integer> map = new HashMap<>();
        for (User user : users) {
            map.put(user.getSex(), map.getOrDefault(user.getSex(), 0) + user.getSpending());
        }
        return map;
    }

    private static Map<String, Set<User>> getCityWithUsers(List<User> users) {
        Map<String, Set<User>> map = new HashMap<>();
        for (User user : users) {
            Set<User> temp = new HashSet<>(map.getOrDefault(user.getCity(), new HashSet<>()));
            temp.add(user);
            map.put(user.getCity(), temp);
        }
        return map;
    }

    private static Map<Role, Set<User>> getRoleWithUsers(List<User> users) {
        Map<Role, Set<User>> map = new HashMap<>();
        for (User user : users) {
            Set<User> temp = new HashSet<>(map.getOrDefault(user.getRole(), new HashSet<>()));
            temp.add(user);
            map.put(user.getRole(), temp);
        }
        return map;
    }

    private static Map<Integer, Set<User>> getYearWithUsers(List<User> users) {
        Map<Integer, Set<User>> map = new TreeMap<>();
        for (User user : users) {
            int yearOfBirth = user.getDateOfBirth().getYear();
            Set<User> temp = new HashSet<>(map.getOrDefault(yearOfBirth, new HashSet<>()));
            temp.add(user);
            map.put(yearOfBirth, temp);
        }
        return map;
    }

    private static List<User> sortByYearOfBirth(List<User> users) {
        List<User> result = new ArrayList<>();
        Map<Integer, Set<User>> map = getYearWithUsers(users);
        for (Map.Entry<Integer, Set<User>> integerSetEntry : map.entrySet()) {
            result.addAll(integerSetEntry.getValue());
        }
        return result;
    }

    private static List<User> newListByRole(List<User> users, Role role) {
        List<User> result;
        try {
            result = new ArrayList<>(getRoleWithUsers(users).get(role));
        } catch (NullPointerException e) {
            return null;
        }
        return result;
    }
}
