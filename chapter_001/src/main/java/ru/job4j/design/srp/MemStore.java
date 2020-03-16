package ru.job4j.design.srp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author RVohmin
 * @since 16.03.2020
 */
public class MemStore implements Store {
    private final List<Employer> employers = new ArrayList<>();

    public void add(Employer em) {
        employers.add(em);
    }

    @Override
    public List<Employer> findBy(Predicate<Employer> filter) {
        return employers.stream().filter(filter).collect(Collectors.toList());
    }
}
