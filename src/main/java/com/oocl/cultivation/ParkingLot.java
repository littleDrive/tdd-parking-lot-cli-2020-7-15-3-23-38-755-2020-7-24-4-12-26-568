package com.oocl.cultivation;

import java.util.HashMap;

public class ParkingLot {

    int capicity;
//    Map
    HashMap<Ticket, Car> parkingRooms;
    int id;

    public int getCapicity() {
        return capicity;
    }

    public HashMap<Ticket, Car> getParkingRooms() {
        return parkingRooms;
    }

    public int getId() {
        return id;
    }

    public ParkingLot(int capacity) {
        this.capicity = capacity;
        parkingRooms = new HashMap<>();
    }

    public ParkingLot() {
        this(10);
    }

    public ParkingLot(int capicity, int id) {
        this(capicity);
        this.id = id;
    }

    public Ticket park(Car car) {
        Ticket ticket = null;
        if (parkingRooms.size() < capicity) {
            ticket = new Ticket(this.id);
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
