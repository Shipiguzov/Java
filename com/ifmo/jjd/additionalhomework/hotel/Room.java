package com.ifmo.jjd.additionalhomework.hotel;

import java.time.LocalDate;

public class Room implements RoomActions {

    private int num;
    private int price;
    private RoomsList classOfRoom;
    private LocalDate busyFrom;
    private LocalDate busyTo;

    public Room(int num, int price, RoomsList classOfRoom) {
        this.setNum(num);
        this.setPrice(price);
        this.setClassOfRoom(classOfRoom);
        this.busyTo = LocalDate.now();
        this.busyFrom = LocalDate.now();
        this.classOfRoom = classOfRoom;
    }

    public LocalDate getBusyTo() {
        return busyTo;
    }

    public int getNum() {
        return num;
    }

    public int getPrice() {
        return price;
    }

    public RoomsList getClassOfRoom() {
        return classOfRoom;
    }

    public void setNum(int num) {
        if (num <= 0) throw new IllegalArgumentException("Number of room must be more 0");
        this.num = num;
    }

    public void setPrice(int price) {
        if (price <= 0) throw new IllegalArgumentException("Price must be more 0");
        this.price = price;
    }

    public void setClassOfRoom(RoomsList classOfRoom) {
        if (classOfRoom != RoomsList.BUSINESS && classOfRoom != RoomsList.ECONOM && classOfRoom != RoomsList.PENTHOUSE)
            throw new IllegalArgumentException("Class of room must be: BUSINESS, ECONOM or PENTHOUSE");
        this.classOfRoom = classOfRoom;
    }

    @Override
    public void makeBusy(LocalDate from, LocalDate to) {
        this.busyFrom = from;
        this.busyTo = to;
    }

    @Override
    public boolean checkRoom(int price, RoomsList roomClass, LocalDate bookingFrom, LocalDate bookingTo) {
        if (this.getClassOfRoom() == roomClass && this.price <= price &&
                ((this.busyTo.isBefore(bookingFrom) || this.busyTo.isEqual(bookingFrom)) ||
                this.busyFrom.isAfter(bookingTo) || this.busyFrom.isEqual(bookingTo)))
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Room №: " + this.getNum() + ". Price: " + this.getPrice()
                + " Class: " + this.getClassOfRoom() + " Free from: " + this.getBusyTo();
    }
}
