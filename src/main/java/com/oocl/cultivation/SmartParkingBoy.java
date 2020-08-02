package com.oocl.cultivation;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {


    private static final String NOT_ENOUGH_POSITION = "Not enough position.";

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) {
        Ticket ticket = null;
        int maxEmptyPosition = 0;
        ParkingLot maxEmptyPositionParkingLot = parkingLots.get(0);
        for (ParkingLot parkingLot : parkingLots) {
            int currentParkingLotEmptyPosition = parkingLot.getCapacity() - parkingLot.parkingRooms.size();
            maxEmptyPosition = Math.max(maxEmptyPosition, currentParkingLotEmptyPosition);
            if (maxEmptyPosition == currentParkingLotEmptyPosition) {
                maxEmptyPositionParkingLot = parkingLot;
            }
        }
        if (maxEmptyPosition > 0) {
            return maxEmptyPositionParkingLot.park(car);
        }
        errorMassage = NOT_ENOUGH_POSITION;
        return ticket;
    }
}
