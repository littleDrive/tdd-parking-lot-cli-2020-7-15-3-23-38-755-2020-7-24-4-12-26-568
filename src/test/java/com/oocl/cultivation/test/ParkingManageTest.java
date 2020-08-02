package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
