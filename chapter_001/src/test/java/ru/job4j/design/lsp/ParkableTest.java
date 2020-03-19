package ru.job4j.design.lsp;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParkableTest {

    @Test
    public void whenPark() throws Exception {
        Car car = new CarSmall(100, 555);
        Parking parking = new Parking(5, 10);
        int number = parking.park(car);
        assertEquals(car.number(), number);
    }


    @Test
    public void whenUnpark() throws Exception {
        Car car = new CarSmall(100, 555);
        Parking parking = new Parking(5, 10);
        parking.park(car);
        assertEquals(car, parking.unpark(555));
    }

    @Test(expected = Exception.class)
    public void whenParkingSmallCoundNotAcceptNewCarThrowException() throws Exception {
        Car car = new CarSmall(100, 555);
        Parking parking = new Parking(0, 1);
        int number = parking.park(car);
        assertEquals(car.number(), parking.park(car));
    }

    @Test(expected = Exception.class)
    public void whenParkingBigCoundNotAcceptNewCarThrowException() throws Exception {
        Car car = new CarSmall(200, 555);
        Parking parking = new Parking(0, 1);
        int number = parking.park(car);
        assertEquals(car.number(), parking.park(car));
    }

    @Test
    public void whenParkink5Big10Small() throws Exception {
        Car car1 = new CarSmall(100, 555);
        Car car2 = new CarSmall(100, 111);
        Car car3 = new CarSmall(100, 222);
        Car carBig1 = new CarSmall(200, 333);
        Car carBig2 = new CarSmall(200, 444);
        Car carBig3 = new CarSmall(200, 777);
        Parking parking = new Parking(2, 5);
        parking.park(car1);
        parking.park(car2);
        parking.park(car3);
        parking.park(carBig1);
        parking.park(carBig2);
        int number = parking.park(carBig3);
        assertEquals(carBig3.number(), number);
    }
}
