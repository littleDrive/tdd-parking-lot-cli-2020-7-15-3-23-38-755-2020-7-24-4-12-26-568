package com.oocl.cultivation;

public class ParkingBoy {

    public Ticket park(Car car) {
        ParkingLot parkingLot = new ParkingLot();
        return parkingLot.park(car);
    }
}
