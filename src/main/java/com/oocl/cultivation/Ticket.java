package com.oocl.cultivation;

public class Ticket {

    int parkingLotId;

    public Ticket(){

    }
    public Ticket(int parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public int getParkingLotId() {
        return parkingLotId;
    }
}
