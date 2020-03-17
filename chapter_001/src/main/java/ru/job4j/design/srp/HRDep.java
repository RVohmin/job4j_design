package ru.job4j.design.srp;

import java.util.*;
import java.util.function.Predicate;

/**
 * @author RVohmin
 * @since 16.03.2020
 */
public class HRDep implements Department {
    @Override
    public Map<String, String> makeReport(Predicate<Employer> filter, Store store) {
        Map<String, String> map = new LinkedHashMap<>();
        List<Employer> list = store.findBy(filter);
        list.sort(new SortReverseEmpSalary());
        System.out.println(list);
        int count = 1;
        for (Employer employer : list) {
            map.put(count + ". name: ", employer.getName());
            map.put(count + ". salary: ", employer.getSalary() + " euros;");
            count++;
        }

        return map;
    }
}
