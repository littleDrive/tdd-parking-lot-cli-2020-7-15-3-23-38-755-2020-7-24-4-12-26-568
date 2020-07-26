package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParkingBoy {

    String errorMassage;
    List<ParkingLot> parkingLots;


    public ParkingBoy() {
        this(new ParkingLot());
    }
    public ParkingBoy(ParkingLot parkingLot) {
       parkingLots = new ArrayList<>();
       parkingLots.add(parkingLot);
    }

    public ParkingBoy(List parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {

        Ticket ticket = parkingLots.get(0).park(car);
        if (ticket == null) {
            errorMassage = "Not enough position.";
        }
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        Car car = parkingLots.get(0).fetch(ticket);
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
