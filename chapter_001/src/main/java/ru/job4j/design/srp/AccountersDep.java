package ru.job4j.design.srp;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * @author RVohmin
 * @since 17.03.2020
 */
public class AccountersDep implements Department {
    private final Double euroPerRouble = 85.3;
    @Override
    public Map<String, String> makeReport(Predicate<Employer> filter, Store store) {
        Map<String, String> map = new LinkedHashMap<>();
        int count = 1;
        for (Employer employer : store.findBy(filter)) {
            map.put(count + ". name: ", employer.getName());
            map.put(count + ". hired: ", employer.getHired().toString());
            map.put(count + ". fired: ", employer.getFired().toString());
            map.put(count + ". salary: ", employer.getSalary() * euroPerRouble + "roubles");
            count++;
        }
        return map;
    }
}
