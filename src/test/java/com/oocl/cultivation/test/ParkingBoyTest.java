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


}
