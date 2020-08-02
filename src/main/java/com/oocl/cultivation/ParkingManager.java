package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager extends ParkingBoy{


    List<ParkingBoy> parkingBoys;

    public ParkingManager(List<ParkingLot> parkingLots) {
        super(parkingLots);
        parkingBoys = new ArrayList<>();
    }

    public Ticket park(ParkingBoy parkingBoy, Car car) {
        Ticket ticket = parkingBoy.park(car);
        if (ticket == null) {
            errorMassage = parkingBoy.queryErrorMassage();
        }
        return ticket;
    }

    public void addParkingBoye(ParkingBoy parkingBoy) {
        parkingBoys.add(parkingBoy);
    }

    public List<ParkingBoy> getParkingBoys() {
        return parkingBoys;
    }

    public Car fetch(ParkingBoy parkingBoy, Ticket ticket) {
        Car car = parkingBoy.fetch(ticket);
        if (car == null) {
            errorMassage = parkingBoy.queryErrorMassage();
        }
        return car;
    }
}
