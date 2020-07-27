package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ParkingLotTest {
    @Test
    void should_return_ticket_when_parking_car_given_car() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();

        //when
        Ticket ticket = parkingLot.park(car);

        //then
        assertNotNull(ticket);

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
        assertEquals(parking_car, fetch_car);

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
        assertNotNull(ticket1);
        assertNotNull(ticket2);
        assertNotNull(ticket3);
    }

    @Test
    void should_return_cars_when_fetch_cars_given_tickets() {
        //given
        Car parking_car1 = new Car();
        Car parking_car2 = new Car();
        Car parking_car3 = new Car();
        ParkingLot parkingLot = new ParkingLot();
        Ticket ticket1 = parkingLot.park(parking_car1);
        Ticket ticket2 = parkingLot.park(parking_car2);
        Ticket ticket3 = parkingLot.park(parking_car3);

        //when
        Car fetch_car1 = parkingLot.fetch(ticket1);
        Car fetch_car2 = parkingLot.fetch(ticket2);
        Car fetch_car3 = parkingLot.fetch(ticket3);

        //then
        assertEquals(parking_car1, fetch_car1);
        assertEquals(parking_car2, fetch_car2);
        assertEquals(parking_car3, fetch_car3);
    }

    @Test
    void should_not_be_fetched_when_fetch_car_given_wrong_ticket() {
        //given
        Ticket wrongTicket = new Ticket();
        ParkingLot parkingLot = new ParkingLot();

        //when
        Car car = parkingLot.fetch(wrongTicket);

        //then
        assertNull(car);
    }

    @Test
    void should_not_return_car_when_fetch_car_given_a_ticket_which_aleady_be_used() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        Ticket newTicket = parkingLot.park(car);
        Car fetchCarByNewTicket = parkingLot.fetch(newTicket);
        Ticket oldTicket = newTicket;

        //when
        Car fetchCarByOldTicket = parkingLot.fetch(oldTicket);

        //then
        assertNull(fetchCarByOldTicket);
    }

    @Test
    void should_not_park_car_and_not_return_ticket_when_park_given_parkingRooms_size_big_than_10() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        for (int i = 0; i < 10; i++) {
            parkingLot.park(new Car());
        }

        //when
        Ticket ticket = parkingLot.park(car);

        //then
        //todo
        assertNull(ticket);
    }

    @Test
    void shoule_not_return_car_when_fetch_car_given_nothing() {
        //given
        Car car =  new Car();
        ParkingLot parkingLot = new ParkingLot();
        Ticket ticket = parkingLot.park(car);

        //when
        Car not_given_ticket_to_fetch_car = parkingLot.fetch();

        //then
        assertNull(not_given_ticket_to_fetch_car);
    }
}
