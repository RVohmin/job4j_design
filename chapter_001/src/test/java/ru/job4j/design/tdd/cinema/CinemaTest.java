package ru.job4j.design.tdd.cinema;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class CinemaTest {

    @Ignore@Test
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, Calendar.OCTOBER, 10, 23, 0);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertEquals(ticket, new Ticket3D());
    }
    @Ignore
    @Test
    public void find() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertEquals(List.of(new Session3D()), sessions);
    }

    @Ignore
    @Test
    public void add() {
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        assertEquals(cinema.find(sessionX -> true), session);
    }


}
