package ru.job4j.design.tdd.cinema;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author RVohmin
 * @since 15.03.2020
 */
public interface Cinema {
    List<Session> find(Predicate<Session> filter);

    Ticket buy(Account account, int row, int column, Calendar date);

    void add(Session session);
}
