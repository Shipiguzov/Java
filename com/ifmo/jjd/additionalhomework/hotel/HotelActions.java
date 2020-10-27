package com.ifmo.jjd.additionalhomework.hotel;

import java.time.LocalDate;

public interface HotelActions {

    public void runApplication();

    // ввод дат бронирования
    public LocalDate[] inputDate();

    // Выводит список комнат в зависимости от RoomsList
    public int showAviableRooms(int price, RoomsList roomClass, LocalDate bookingFrom);

    // Ввод желаемой стоимости комнаты и её класса
    public String[] roomInput();

    // Ввод бронируемой комнаты
    public int inputNumberBookingRoom();

    // Бронирование комнаты
    public void roomBooking(int number, LocalDate bookFrom, LocalDate bookTo);
}
