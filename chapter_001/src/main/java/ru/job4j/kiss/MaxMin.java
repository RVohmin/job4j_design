package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

public class MaxMin {
    /**
     * This function used by methods min() & max()
     * @param value - List
     * @param comparator - (x, y) -> x.compareTo(y)
     * @param initValue -1 then finding max or 1 then finding min (Supplier<Integer> initValue)
     * @param <T> Type
     * @return Maxmin
     */
    private <T> T solveMinMax(List<T> value, Comparator<T> comparator, Supplier<Integer> initValue) {
        T rsl = value.get(0);
        for (T item : value) {
            if (comparator.compare(rsl, item) == initValue.get()) {
                rsl = item;
            }
        }
        return rsl;
    }

    /**
     *
     * @param value List
     * @param comparator Comparator
     * @param <T> Type value
     * @return solved min or max
     */
    public <T> T max(List<T> value, Comparator<T> comparator) {
        Supplier<Integer> initValue = () -> -1;
        return solveMinMax(value, comparator, initValue);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        Supplier<Integer> initValue = () -> 1;
        return solveMinMax(value, comparator, initValue);
    }

//    public static void main(String[] args) {
//        List<Integer> list = List.of(79, 69, 49, 19, 19, 21, 22, 23, 34, 5, 66);
//        MaxMin obj = new MaxMin();
//        System.out.println(obj.max(list, Integer::compareTo));
//        System.out.println(obj.min(list, Integer::compareTo));
//
//    }
}
