package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    void should_return_Unrecognized_parking_ticket_when_query_error_massage_given_wrong_ticket() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = new Ticket();

        //when
        Car car = parkingBoy.fetch(ticket);
        String errorMassage = parkingBoy.queryErrorMassage();

        //then
        Assertions.assertEquals("Unrecognized parking ticket.", errorMassage);
    }

    @Test
    void should_return_Please_rovide_our_arking_icket_when_query_error_massage_given_not_provide_ticket() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = new Ticket();

        //when
        Car car = parkingBoy.fetch();
        String errorMassage = parkingBoy.queryErrorMassage();

        //then
        Assertions.assertEquals("Please provide your parking ticket.", errorMassage);

    }

    @Test
    void should_return_Not_enough_position_when_parking_car_given_not_enough_position_parking_lot() {
        //given
        ParkingLot parkingLot = new ParkingLot(0);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        //when
        Ticket ticket = parkingBoy.park(car);
        String errorMassage = parkingBoy.queryErrorMassage();

        //then
        Assertions.assertEquals( "Not enough position.", errorMassage);

    }

    @Test
    void should_park_cars_sequentially_when_parking_car_given_car () {
        //given
        List parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(new ParkingLot(2, 1));
        parkingLots.add(new ParkingLot(2, 2));

        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        //when
        Ticket ticket1 = parkingBoy.park(car1);
        Ticket ticket2 = parkingBoy.park(car2);
        Ticket ticket3 = parkingBoy.park(car3);

        Assertions.assertEquals(1, ticket1.getParkingLotId());
        Assertions.assertEquals(2, ticket2.getParkingLotId());
        Assertions.assertEquals(3, ticket3.getParkingLotId());



    }
}

