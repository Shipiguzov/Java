package com.ifmo.jjd.additionalhomework.hotel;

import java.io.IOException;
import java.util.Scanner;

public final class ServiceHotel {

    public static void printLn(String text) {
        System.out.println(text);
    }

    public static String input() {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        return text;
    }

    public static int fromStringToInt(String input) throws IOException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IOException("Input string must be one number");
        }
    }

    public static boolean isArrayEmpty(int[] array) {
        int count = 0;
        for (int i : array) {
            if (i == 0) count++;
        }
        if (count == array.length) return true;
        return false;
    }
}
