package com.oocl.cultivation;

import java.util.HashMap;

public class ParkingLot {

    int capacity;
//    Map
    HashMap<Ticket, Car> parkingRooms;
    int id;

    public int getCapacity() {
        return capacity;
    }

    public HashMap<Ticket, Car> getParkingRooms() {
        return parkingRooms;
    }

    public int getId() {
        return id;
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        parkingRooms = new HashMap<>();
    }

    public ParkingLot() {
        this(10);
    }

    public ParkingLot(int capacity, int id) {
        this(capacity);
        this.id = id;
    }

    public Ticket park(Car car) {
        Ticket ticket = null;
        if (parkingRooms.size() < capacity) {
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
