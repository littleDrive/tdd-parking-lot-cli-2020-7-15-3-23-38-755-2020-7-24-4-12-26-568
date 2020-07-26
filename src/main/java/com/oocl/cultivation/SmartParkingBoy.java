package com.oocl.cultivation;

import java.util.List;

/**
 * @author ozm
 * @date 2020/7/26 - 16:42
 */
public class SmartParkingBoy extends ParkingBoy {


    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public Ticket park(Car car) {
        Ticket ticket = null;
        int maxEmptyPosition = 0;
        ParkingLot maxEmptyPositionParkingLot = parkingLots.get(0);
        for (ParkingLot parkingLot : parkingLots) {
            int currentParkingLotEmptyPosition = parkingLot.getCapicity() - parkingLot.parkingRooms.size();
            maxEmptyPosition = maxEmptyPosition > currentParkingLotEmptyPosition ? maxEmptyPosition : currentParkingLotEmptyPosition;
            if (maxEmptyPosition == currentParkingLotEmptyPosition) {
                maxEmptyPositionParkingLot = parkingLot;
            }
        }
        if (maxEmptyPosition > 0) {
            return maxEmptyPositionParkingLot.park(car);

        }

        errorMassage = "Not enough position.";
        return ticket;
    }
}
