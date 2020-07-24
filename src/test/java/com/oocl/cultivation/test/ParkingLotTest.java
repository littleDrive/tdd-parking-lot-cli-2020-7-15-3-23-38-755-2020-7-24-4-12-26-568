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

    @Test
    void should_return_tickets_when_parking_cars_given_cars() {
        //given

        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        ParkingLot parkingLot = new ParkingLot();

        //when
        Ticket ticket1 = parkingLot.park(car1);
        Ticket ticket2 = parkingLot.park(car2);
        Ticket ticket3 = parkingLot.park(car3);


        //then
        Assertions.assertNotNull(ticket1);
        Assertions.assertNotNull(ticket2);
        Assertions.assertNotNull(ticket3);
    }


}
