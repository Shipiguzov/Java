package com.ifmo.jjd.additionalhomework.hotel;

import java.io.IOException;
import java.time.LocalDate;

public final class Hotel implements HotelActions {

    Room[] rooms = new Room[10];
    RoomsList wishRoomClass;
    int wishPrice;
    LocalDate currentDate = LocalDate.now();
    LocalDate bookingFrom;
    LocalDate bookingTo;

    private void makingRoomsInHotel(){
        for (int i = 0; i < 5; i++) {
            rooms[i] = new Room(i + 1, 20, RoomsList.ECONOM);
        }
        for (int i = 5; i < 8; i++) {
            rooms[i] = new Room(i + 1, 40, RoomsList.BUSINESS);
        }
        for (int i = 8; i < rooms.length; i++) {
            rooms[i] = new Room(i + 1, 80, RoomsList.PENTHOUSE);
        }
    }

    @Override
    public void runApplication() {
        this.makingRoomsInHotel();
        do {
            String[] wantRoom = this.roomInput();
            int numberOfSuitableRoom;
            int numberOfBookingRoom;
            this.wishPrice = Integer.parseInt(wantRoom[0]);
            this.wishRoomClass = RoomsList.valueOf(wantRoom[1].toUpperCase());
            LocalDate[] bookingDate = this.inputDate();
            this.bookingFrom = bookingDate[0];
            this.bookingTo = bookingDate[1];
            numberOfSuitableRoom = this.showAviableRooms(wishPrice, wishRoomClass, bookingFrom);
            if (numberOfSuitableRoom == 0) {
                ServiceHotel.printLn("There is no suitable rooms");
                continue;
            }
            numberOfBookingRoom = this.inputNumberBookingRoom();
            this.roomBooking(numberOfBookingRoom, bookingFrom, bookingTo);
        } while (true);
    }

    @Override
    public LocalDate[] inputDate() {
        String text;
        String[] input;
        LocalDate dateFrom, dateTo;
        do {
            ServiceHotel.printLn("Enter a booking date (from to) in YYYY-MM-DD format: ");
            text = ServiceHotel.input();
            input = text.split(" ");
            try {
                Checking.checkDate(input);
                dateFrom = LocalDate.parse(input[0]);
                dateTo = LocalDate.parse(input[1]);
                break;
            } catch (IllegalArgumentException e) {
                ServiceHotel.printLn(e.getMessage());
                continue;
            }
        } while (true);

        return new LocalDate[] {dateFrom, dateTo};
    }

    @Override
    public int showAviableRooms(int price, RoomsList roomClass, LocalDate bookingFrom) {
        int count = 0;
        for (Room room : this.rooms) {
            if (room.checkRoom(price, roomClass, bookingFrom, bookingTo)) {
                ServiceHotel.printLn(room.toString());
                count++;
            }
        }
        return count;
    }

    @Override
    public String[] roomInput() {
        String text;
        String[] input;
        do {
            ServiceHotel.printLn("Please enter a price and a class of room: (" +
                    RoomsList.ECONOM + ", " +
                    RoomsList.BUSINESS + " or " +
                    RoomsList.PENTHOUSE + ")");
            text = ServiceHotel.input();
            input = text.split(" ");
            try {
                Checking.checkRoomInput(input);
                break;
            } catch (IllegalArgumentException e) {
                ServiceHotel.printLn(e.getMessage());
                continue;
            }
        } while (true);
        return input;
    }

    @Override
    public int inputNumberBookingRoom() {
        int input;
        do {
            ServiceHotel.printLn("Wich room you want to book? (0 - for exit) ");
            try {
                input = ServiceHotel.fromStringToInt(ServiceHotel.input());
                return input;
            } catch (IOException e) {
                ServiceHotel.printLn(e.getMessage());
                continue;
            }
        } while (true);
    }

    @Override
    public void roomBooking(int number, LocalDate bookFrom, LocalDate bookTo) {
        for (Room room : rooms) {
            if (room.getNum() == number) {
                room.makeBusy(bookFrom, bookTo);
                return;
            }
        }
    }


}
