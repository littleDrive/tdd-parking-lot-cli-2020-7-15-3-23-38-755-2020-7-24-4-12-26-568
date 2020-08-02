package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import javafx.beans.binding.When;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void should_return_ticket_when_parking_car_given_parking_manager() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingManager parkingManager = new ParkingManager(parkingLots);

        //when
        Ticket ticket = parkingManager.park(new Car());

        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_car_when_fetch_car_by_parking_manager_given_parking_manager() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingManager parkingManager = new ParkingManager(parkingLots);
        Car parkCar = new Car();
        Ticket ticket = parkingManager.park(parkCar);

        //when
        Car fetchCar = parkingManager.fetch(ticket);
        //then
        assertEquals(parkCar, fetchCar);
    }

    @Test
    void should_return_error_massage_when_parking_boy_can_not_parking_car_given_parking_manager() {
        //given
        ParkingLot parkingLot = new ParkingLot(1, 1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingManager parkingManage = new ParkingManager(parkingLots);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingManage.addParkingBoye(parkingBoy);
        parkingManage.park(parkingManage.getParkingBoys().get(0), new Car());

        //when
        Ticket ticket = parkingManage.park(parkingManage.getParkingBoys().get(0), new Car());

        //then
        assertNull(ticket);
        assertEquals("Not enough position.", parkingManage.queryErrorMassage());
    }

    @Test
    void should_return_error_massage_when_parking_boy_can_not_fetch_car_given_parking_manager() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingManager parkingManage = new ParkingManager(parkingLots);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingManage.addParkingBoye(parkingBoy);
        Car parkedCar = new Car();
        Ticket ticket = parkingManage.park(parkingManage.getParkingBoys().get(0), parkedCar);

        //when
        Car fetchedCar = parkingManage.fetch(parkingManage.getParkingBoys().get(0), new Ticket());

        //then
        assertNull(fetchedCar);
        assertEquals("Unrecognized parking ticket.", parkingManage.queryErrorMassage());
    }
}
