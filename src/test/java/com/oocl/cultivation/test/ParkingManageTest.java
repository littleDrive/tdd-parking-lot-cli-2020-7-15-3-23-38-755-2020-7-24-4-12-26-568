package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingManageTest {

    @Test
    void should_add_a_parking_boy_when_add_parking_boy_given_parking_boy()
    {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingManager parkingManage = new ParkingManager(parkingLots);
        ParkingBoy parkingBoy = new ParkingBoy();

        //when
       parkingManage.addParkingBoye(parkingBoy);

        //then
        assertEquals(1 , parkingManage.getParkingBoys().size());

    }

    @Test
    void should_return_ticket_when_parking_car_given_parking_boy() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingManager parkingManage = new ParkingManager(parkingLots);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingManage.addParkingBoye(parkingBoy);

        //when
        Ticket ticket = parkingManage.park(parkingManage.getParkingBoys().get(0), new Car());

        //then
        assertNotNull(ticket);
    }
}
