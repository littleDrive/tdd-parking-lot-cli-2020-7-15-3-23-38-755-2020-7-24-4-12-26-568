package com.oocl.cultivation;

import java.util.List;

/**
 * @author ozm
 * @date 2020/7/26 - 18:42
 */
public class SuperSmartParkingBoy extends ParkingBoy {

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public Ticket park(Car car) {
        Ticket ticket = null;
        double largerAvailablePosition = 0;
        ParkingLot largerAvailablePositionParkingLot = parkingLots.get(0);
        for (ParkingLot parkingLot : parkingLots) {
            double currentParkingLotAvailablePosition = (double) (parkingLot.getCapicity() - parkingLot.parkingRooms.size()) / parkingLot.getCapicity() ;
            if (largerAvailablePosition < currentParkingLotAvailablePosition) {
                largerAvailablePosition = currentParkingLotAvailablePosition;
                largerAvailablePositionParkingLot = parkingLot;
            }
        }
        if (largerAvailablePosition > 0) {
            return largerAvailablePositionParkingLot.park(car);

        }

        errorMassage = "Not enough position.";
        return ticket;
    }

}
