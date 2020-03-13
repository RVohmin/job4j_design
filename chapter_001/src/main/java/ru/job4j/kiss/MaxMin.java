package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

public class MaxMin {

    private <T> T solveMinMax(List<T> value, Comparator<T> comparator, Supplier<Integer> initValue) {
        T rsl = value.get(0);
        for (T item : value) {
            if (comparator.compare(rsl, item) == initValue.get()) {
                rsl = item;
            }
        }
        return rsl;
    }
    public <T> T max(List<T> value, Comparator<T> comparator) {
        Supplier<Integer> initValue = () -> -1;
        return solveMinMax(value, comparator, initValue);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        Supplier<Integer> initValue = () -> 1;
        return solveMinMax(value, comparator, initValue);
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(79, 69, 49, 19, 22, 34, 5, 66);
        MaxMin obj = new MaxMin();
        System.out.println(obj.max(list, Integer::compareTo));
        System.out.println(obj.min(list, Integer::compareTo));

    }
}
