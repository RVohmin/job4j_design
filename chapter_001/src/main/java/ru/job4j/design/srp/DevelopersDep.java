package ru.job4j.design.srp;

import java.util.*;
import java.util.function.Predicate;

/**
 * @author RVohmin
 * @since 17.03.2020
 */
public class DevelopersDep implements Department {
    @Override
    public Map<String, String> makeReport(Predicate<Employer> filter, Store store) {
        Map<String, String> map = new LinkedHashMap<>();
        var count = 1;
        for (Employer employer : store.findBy(filter)) {
            map.put(count + ". name: ", employer.getName());
            map.put(count + ". hired: ", employer.getHired().toString());
            map.put(count + ". fired: ", employer.getFired().toString());
            map.put(count + ". salary: ", employer.getSalary() + "");
            count++;
        }
        return map;
    }


}
