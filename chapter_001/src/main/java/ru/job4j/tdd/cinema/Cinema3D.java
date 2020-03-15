package ru.job4j.tdd.cinema;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author RVohmin
 * @since 15.03.2020
 */
public class Cinema3D implements Cinema {
    public static List<Session> list;

    @Override
    public List<Session> find(Predicate<Session> filter) {
        return null;
    }

    @Override
    public Ticket buy(Account account, int row, int column, Calendar date) {
        return null;
    }

    @Override
    public void add(Session session) {

    }
}
