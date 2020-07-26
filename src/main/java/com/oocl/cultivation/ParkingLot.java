package com.oocl.cultivation;

import java.util.HashMap;

public class ParkingLot {

    int capicity;
    HashMap<Ticket, Car> parkingRooms;
    int id;

    public int getId() {
        return id;
    }

    public ParkingLot(int capicityi) {
        this.capicity = capicityi;
        parkingRooms = new HashMap<>();
    }

    public ParkingLot() {
        this(10);
    }

    public ParkingLot(int capicity, int id) {
        parkingRooms = new HashMap<>();
        this.capicity = capicity;
        this.id = id;
    }

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
