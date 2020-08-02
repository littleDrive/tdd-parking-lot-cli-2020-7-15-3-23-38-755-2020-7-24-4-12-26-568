package com.oocl.cultivation;

import java.util.List;

public class ParkingBoy {

    private static final String NOT_ENOUGH_POSITION = "Not enough position.";
    public static final String UNRECOGNIZED_PARKING_TICKET = "Unrecognized parking ticket.";
    public static final String PLEASE_PROVIDE_YOUR_PARKING_TICKET = "Please provide your parking ticket.";
    String errorMassage;
    List<ParkingLot> parkingLots;


    public ParkingBoy(List<ParkingLot> parkingLots) {
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
        errorMassage = UNRECOGNIZED_PARKING_TICKET;
        return car;
    }

    public Car fetch() {
            errorMassage = PLEASE_PROVIDE_YOUR_PARKING_TICKET;
            return null;
    }

    public String queryErrorMassage() {
        return errorMassage;
    }
}
