package com.ifmo.jjd.additionalhomework.hotel;

import java.time.LocalDate;

public interface RoomActions {

    // бронирует комнату со времени LocalDate from до LocalDate to
    public void makeBusy(LocalDate from, LocalDate to);

    // Проверка подходит ли комната
    public boolean checkRoom(int price, RoomsList roomClass, LocalDate bookingFrom, LocalDate bookingTo);

}
