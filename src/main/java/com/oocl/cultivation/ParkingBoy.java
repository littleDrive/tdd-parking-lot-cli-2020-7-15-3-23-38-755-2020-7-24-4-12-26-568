package com.oocl.cultivation;

public class ParkingBoy {

    ParkingLot parkingLot;
    String errorMassage;

    public ParkingBoy(ParkingLot parkingLot) {
       this.parkingLot = parkingLot;
    }

    public ParkingBoy() {
        this(new ParkingLot());
    }

    public Ticket park(Car car) {

        Ticket ticket =  parkingLot.park(car);
        if (ticket == null) {
            errorMassage = "Not enough position.";
        }
        return ticket;
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
