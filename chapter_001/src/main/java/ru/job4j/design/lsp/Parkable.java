package ru.job4j.design.lsp;

/**
 * @author RVohmin
 * @since 18.03.2020
 */
public interface Parkable {
    int park(Car car) throws Exception;
    Car unpark(int car);
}
