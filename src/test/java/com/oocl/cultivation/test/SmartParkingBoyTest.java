package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingBoyTest {
    @Test
    void should_park_cars_to_the_parking_lot_which_contains_more_empty_positions_when_parking_cars() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(5, 1));
        parkingLots.add(new ParkingLot(10, 2));
        parkingLots.add(new ParkingLot(15, 3));

        ParkingBoy smarkParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();

        //when
        Ticket ticket = smarkParkingBoy.park(car);

        //then
        assertEquals(3, ticket.getParkingLotId());

    }

}
