package com.oocl.cultivation;

import java.util.HashMap;

public class ParkingLot {
    int capicity = 10;
    HashMap<Ticket, Car> parkingRooms = new HashMap<>();

    public Ticket park(Car car) {
        Ticket ticket = null;
        if (parkingRooms.size() < capicity) {
            ticket = new Ticket();
            parkingRooms.put(ticket, car);
        }
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        if (ticket == null || !parkingRooms.containsKey(ticket)) {
            return null;
        }

        Car car = parkingRooms.get(ticket);
        parkingRooms.remove(ticket);
        return car;
    }

    public Car fetch() {
        return null;
    }
}
