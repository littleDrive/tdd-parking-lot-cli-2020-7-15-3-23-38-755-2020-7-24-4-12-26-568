package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ParkingLotTest {
    @Test
    void should_return_ticket_when_parking_car_given_car() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();

        //when
        Ticket ticket = parkingLot.park(car);

        //then
        Assertions.assertNotNull(ticket);
    }

    @Test
    void should_return_car_when_fetch_car_given_ticket() {
        //given
        Car parking_car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        Ticket ticket = parkingLot.park(parking_car);

        //when
        Car fetch_car = parkingLot.fetch(ticket);

        //then
        Assertions.assertEquals(parking_car, fetch_car);

    }
}
