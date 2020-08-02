package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SuperSmartParkingBoyTest {
    @Test
    void should_park_cars_to_the_parking_lot_which_has_a_larger_available_position_rate_when_park_car() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(5, 1));
        for (int i = 0; i < 3; i++) {
            parkingLots.get(0).park(new Car());
        }
        parkingLots.add(new ParkingLot(10, 2));
        for (int i = 0; i < 4; i++) {
            parkingLots.get(1).park(new Car());
        }
        parkingLots.add(new ParkingLot(15, 3));
        for (int i = 0; i < 8; i++) {
            parkingLots.get(2).park(new Car());
        }

        ParkingBoy superSmarkParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Car car = new Car();

        //when
        Ticket ticket = superSmarkParkingBoy.park(car);

        //then
        assertEquals(2, ticket.getParkingLotId());
    }
}
