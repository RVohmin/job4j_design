package ru.job4j.design.srp;

import java.util.Comparator;

/**
 * @author RVohmin
 * @since 16.03.2020
 */
public class SortReverseEmpSalary implements Comparator<Employer> {

    @Override
    public int compare(Employer o1, Employer o2) {
        return Double.compare(o2.getSalary(), o1.getSalary());
    }
}
