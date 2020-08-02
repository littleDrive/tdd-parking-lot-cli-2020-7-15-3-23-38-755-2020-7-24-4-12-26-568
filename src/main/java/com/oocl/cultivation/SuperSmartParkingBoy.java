package com.oocl.cultivation;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {

    private static final String NOT_ENOUGH_POSITION = "Not enough position.";

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) {
        Ticket ticket = null;
        double largerAvailablePosition = 0;
        ParkingLot largerAvailablePositionParkingLot = parkingLots.get(0);
        for (ParkingLot parkingLot : parkingLots) {
            double currentParkingLotAvailablePosition = (double) (parkingLot.getCapacity() - parkingLot.parkingRooms.size()) / parkingLot.getCapacity() ;
            if (largerAvailablePosition < currentParkingLotAvailablePosition) {
                largerAvailablePosition = currentParkingLotAvailablePosition;
                largerAvailablePositionParkingLot = parkingLot;
            }
        }
        if (largerAvailablePosition > 0) {
            return largerAvailablePositionParkingLot.park(car);

        }

        errorMassage = NOT_ENOUGH_POSITION;
        return ticket;
    }

}
