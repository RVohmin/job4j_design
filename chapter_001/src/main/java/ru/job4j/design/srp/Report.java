package ru.job4j.design.srp;

import java.util.function.Predicate;

/**
 * @author RVohmin
 * @since 16.03.2020
 */
public interface Report {
    String generateText(Predicate<Employer> filter, Store store);
}
