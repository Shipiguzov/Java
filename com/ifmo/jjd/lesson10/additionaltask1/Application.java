package com.ifmo.jjd.lesson10.additionaltask1;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputString = "";
        LocalDateTime departureSidneyTime, departureHustonTime, departureWashingtonTime;
        LocalDateTime arrivalOttawaTime, arrivalHustonTime, arrivalWashingtonTime;
        /*System.out.println("Enter date and time of arrival (YYYY-MM-DDTHH:MM:SS)");
        inputString = input.next();
        departureSidneyTime = LocalDateTime.parse(inputString);*/
        departureSidneyTime = LocalDateTime.of(2020, Month.JUNE, 16, 00, 00);
        arrivalHustonTime =  departureSidneyTime.plusHours(15).plusMinutes(15);
        departureHustonTime = arrivalHustonTime.plusHours(1);
        arrivalWashingtonTime = departureHustonTime.plusHours(2).plusMinutes(49);
        departureWashingtonTime = arrivalWashingtonTime.plusHours(1).plusMinutes(10);
        arrivalOttawaTime = departureWashingtonTime.plusHours(1).plusMinutes(40);
        System.out.println("Arrival time in Ottawa " + arrivalOttawaTime.atZone(ZoneId.of("America/Toronto")));
        System.out.println("Departure time in Huston " + departureHustonTime.atZone(ZoneId.of("America/Chicago")));
        System.out.println("Departure time in Washington " + departureWashingtonTime.atZone(ZoneId.of("America/New_York")));
    }
}
