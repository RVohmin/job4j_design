package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

public class MaxMin {
    /**
     * This function used by methods min() & max()
     * @param value - List
     * @param predict - BiPredicate
     * @param <T> Type
     * @return Maxmin
     */
    private <T> T solveMinMax(List<T> value, BiPredicate<T, T> predict) {
        T rsl = value.get(0);
        for (T item : value) {
            if (predict.test(rsl, item)) {
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
        return solveMinMax(value, (left, right) -> comparator.compare(left, right) <= 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return solveMinMax(value, (left, right) -> comparator.compare(left, right) >= 0);
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(-288, 49, 79, 69, 49, 19, 19, 79, 21, 22, 23, 34, 5, 66);
        MaxMin obj = new MaxMin();
        System.out.println(obj.max(list, Integer::compareTo));
        System.out.println(obj.min(list, Integer::compareTo));

    }
}
