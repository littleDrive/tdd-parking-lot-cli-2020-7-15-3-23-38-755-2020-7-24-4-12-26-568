package com.oocl.cultivation;

public class ParkingBoy {


    public Ticket park(Car car) {
        ParkingLot parkingLot = new ParkingLot();
        return parkingLot.park(car);
    }

    public Car fetch(Ticket ticket) {
        ParkingLot parkingLot = new ParkingLot();
        return parkingLot.fetch(ticket);
    }

    public String queryErrorMassage() {
        return "Unrecognized parking ticket.";
    }
}
