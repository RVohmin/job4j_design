package ru.job4j.design.lsp;

import java.util.Objects;

/**
 * @author RVohmin
 * @since 18.03.2020
 */
public class CarSmall implements Car {
    int size;
    int number;

    public CarSmall(int size, int number) {
        this.size = size;
        this.number = number;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int number() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CarSmall)) {
            return false;
        }
        CarSmall carSmall = (CarSmall) o;
        return size == carSmall.size
                && number == carSmall.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, number);
    }
}
