package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager extends ParkingBoy{

    private static final String NOT_ENOUGH_POSITION = "Not enough position.";
    public static final String UNRECOGNIZED_PARKING_TICKET = "Unrecognized parking ticket.";
    public static final String PLEASE_PROVIDE_YOUR_PARKING_TICKET = "Please provide your parking ticket.";

    List<ParkingBoy> parkingBoys;

    public ParkingManager(List<ParkingLot> parkingLots) {
        super(parkingLots);
        parkingBoys = new ArrayList<>();
    }

    public Ticket park(ParkingBoy parkingBoy, Car car) {
        Ticket ticket = parkingBoy.park(car);
        if (ticket == null) {
            errorMassage = NOT_ENOUGH_POSITION;
        }
        return ticket;
    }

    public void addParkingBoye(ParkingBoy parkingBoy) {
        parkingBoys.add(parkingBoy);
    }

    public List<ParkingBoy> getParkingBoys() {
        return parkingBoys;
    }
}
