package com.ifmo.jjd.additionalhomework.hotel;

import javax.swing.text.html.HTMLDocument;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

public class Checking {

    public static void checkRoomInput(String[] input) throws IllegalArgumentException {
        if (input.length != 2) throw new IllegalArgumentException("Must be only 2 words (your input = " + Arrays.toString(input) + ")");
        if (Integer.parseInt(input[0]) < 0 ||
                input.length > 2 || (
                !input[1].equalsIgnoreCase(RoomsList.ECONOM.toString()) &&
                        !input[1].equalsIgnoreCase(RoomsList.BUSINESS.toString()) &&
                        !input[1].equalsIgnoreCase(RoomsList.PENTHOUSE.toString())))
            throw new IllegalArgumentException("Class must be econom, business or penthouse (your input = " + Arrays.toString(input) + ")" );
    }

    public static void checkDate(String[] input) throws IllegalArgumentException {
        if (input.length != 2) throw new IllegalArgumentException("Must be 2 words in YYYY-MM-DD format (your input = " + Arrays.toString(input) + ")");
        try {
            LocalDate date1 = LocalDate.parse(input[0]);
            LocalDate date2 = LocalDate.parse(input[1]);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Date must be in YYYY-MM-DD format (your input = " + Arrays.toString(input) + ")");
        }
    }
}

