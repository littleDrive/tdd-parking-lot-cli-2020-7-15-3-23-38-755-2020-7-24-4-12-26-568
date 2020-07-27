package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {

    private static final String NOT_ENOUGH_POSITION = "Not enough position.";
    String errorMassage;
    List<ParkingLot> parkingLots;


    public ParkingBoy(List parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        Ticket ticket = null;
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.capacity > parkingLot.parkingRooms.size()) {
                ticket = parkingLot.park(car);
                return ticket;
            }
        }

        errorMassage = NOT_ENOUGH_POSITION;
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        Car car = null;
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getParkingRooms().containsKey(ticket)){
                car = parkingLot.fetch(ticket);
                return car;
            }
        }
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
