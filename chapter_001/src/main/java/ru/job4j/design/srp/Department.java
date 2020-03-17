package ru.job4j.design.srp;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * @author RVohmin
 * @since 17.03.2020
 */
public interface Department {
    Map<String, String> makeReport(Predicate<Employer> filter, Store store);
}
