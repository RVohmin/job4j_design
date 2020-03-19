package ru.job4j.design.lsp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RVohmin
 * @since 18.03.2020
 */
public class Parking implements Parkable {
    private Map<Integer, Car> carList = new HashMap<>();
    private final int smallPlaceSize = 100;
    private final int bigPlaceSize = 200;
    private int bigCount;
    private int smallCount;

    /**
     * Constructor
     * @param bigCount - количество мест для грузовиков
     * @param smallCount - количество мест для легковых
     */
    public Parking(int bigCount, int smallCount) {
        this.bigCount = bigCount;
        this.smallCount = smallCount;
    }

    public int getSizeParking() {
        return bigCount * bigPlaceSize + smallCount * smallPlaceSize;
    }

    @Override
    public int park(Car car) throws Exception {
            if (car.size() <= 100 && smallCount > 0) {
                smallCount -= 1;
            } else if (car.size() <= 100 && smallCount == 0) {
                throw new Exception("Нет мест для легковых авто");
            }

            if (car.size() > 100 && bigCount > 0) {
                bigCount -= 1;
            } else if (car.size() > 100 && bigCount == 0 && smallCount >= 2) {
                smallCount -= 2;
            } else if (car.size() > 100 && bigCount == 0 && smallCount < 2) {
                throw new Exception("Нет мест для грузовиков");
            }
            carList.put(car.number(), car);
        return car.number();
    }

    @Override
    public Car unpark(int carNumber) {
        Car car = carList.get(carNumber);
        carList.remove(carNumber);
        return car;
    }

    public static void main(String[] args) throws Exception {
        Car car = new CarSmall(100, 555);
        Parking parking = new Parking(5, 10);
        parking.park(car);
        int number = parking.park(car);
        System.out.println(number);
    }
}
