package com.oocl.cultivation;

public class ParkingBoy {

    ParkingLot parkingLot = new ParkingLot();
    String errorMassage;

    public Ticket park(Car car) {
        return parkingLot.park(car);
    }

    public Car fetch(Ticket ticket) {
        Car car = parkingLot.fetch(ticket);
        if (car.equals(null)) {
            errorMassage = "Unrecognized parking ticket.";
        }
        return car;
    }

    public void fetch() {
            errorMassage =  "Please provide your parking ticket.";
    }

    public String queryErrorMassage() {
        return errorMassage;
    }
}
