package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingBoyTest {

    @Test
    void should_return_ticket_when_parking_car_given_car() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();

        //when
        Ticket ticket = parkingBoy.park(car);

        //then
        Assertions.assertNotNull(ticket);

    }
}
