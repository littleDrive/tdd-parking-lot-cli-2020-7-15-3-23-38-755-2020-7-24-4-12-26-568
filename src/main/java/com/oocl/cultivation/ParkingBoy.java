package com.oocl.cultivation;

public class ParkingBoy {

    ParkingLot parkingLot;
    String errorMassage;

    public ParkingBoy(ParkingLot parkingLot) {
       this.parkingLot = parkingLot;
    }

    public ParkingBoy() {
        parkingLot = new ParkingLot();
    }

    public Ticket park(Car car) {
        return parkingLot.park(car);
    }

    public Car fetch(Ticket ticket) {
        Car car = parkingLot.fetch(ticket);
        if (car == null) {
            errorMassage = "Unrecognized parking ticket.";
        }
        return car;
    }

    public Car fetch() {
            errorMassage =  "Please provide your parking ticket.";
            return null;
    }

    public String queryErrorMassage() {
        return errorMassage;
    }
}
