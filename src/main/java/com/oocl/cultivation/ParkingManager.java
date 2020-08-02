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
        return parkingBoy.park(car);
    }

    public void addParkingBoye(ParkingBoy parkingBoy) {
//        parkingBoys.add(parkingBoy);
    }

    public List<ParkingBoy> getParkingBoys() {
        return parkingBoys;
    }
}
