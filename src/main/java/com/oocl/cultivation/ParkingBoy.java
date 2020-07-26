package com.oocl.cultivation;

public class ParkingBoy {

    String errorMassage;

    public Ticket park(Car car) {
        ParkingLot parkingLot = new ParkingLot();
        return parkingLot.park(car);
    }

    public Car fetch(Ticket ticket) {
        ParkingLot parkingLot = new ParkingLot();
        Car car = parkingLot.fetch(ticket);
        if (car == null) {
            errorMassage = "Unrecognized parking ticket.";
        }
        return car;
    }

    public Car fetch() {
        ParkingLot parkingLot = new ParkingLot();
        Car car = parkingLot.fetch();
        if (car == null) {
            errorMassage =  "Please provide your parking ticket.";
        }
        return car;
    }

    public String queryErrorMassage() {
        return errorMassage;
    }
}
