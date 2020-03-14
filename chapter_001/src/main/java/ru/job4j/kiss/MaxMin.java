package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class MaxMin {
    /**
     * This function used by methods min() & max()
     * @param value - List
     * @param predict - BiPredicate
     * @param <T> Type
     * @return Maxmin
     */
    private <T> T solveMinMax(List<T> value, BiPredicate<T, T> predict) {
        T rsl = value.iterator().next();
        for (T item : value) {
            if (predict.test(rsl, item)) {
                rsl = item;
            }
        }
        return rsl;
    }

    /**
     * solveMax
     * @param value List
     * @param comparator Comparator
     * @param <T> Type value
     * @return solved max of list
     */
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return solveMinMax(value, (left, right) -> comparator.compare(left, right) <= 0);
    }

    /**
     * solve min
     * @param value List
     * @param comparator incoming comparator
     * @param <T> Type of value
     * @return solve min of list
     */
    public <T> T min(List<T> value, Comparator<T> comparator) {
        return solveMinMax(value, (left, right) -> comparator.compare(left, right) >= 0);
    }
}
