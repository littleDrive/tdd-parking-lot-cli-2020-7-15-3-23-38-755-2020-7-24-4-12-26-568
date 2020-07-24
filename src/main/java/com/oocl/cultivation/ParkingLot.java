package com.oocl.cultivation;

import java.util.HashMap;

public class ParkingLot {
    HashMap<Ticket, Car> parkingRooms = new HashMap<>();

    public Ticket park(Car car) {
        Ticket ticket = new Ticket();
        parkingRooms.put(ticket, car);
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        return parkingRooms.get(ticket);
    }
}
