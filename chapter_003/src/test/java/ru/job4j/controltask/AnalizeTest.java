package ru.job4j.controltask;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AnalizeTest {
    @Test
    public void whenAdded2NewElThenTrue() {
        Analize analize = new Analize();
        Analize.User user1 = new Analize.User(1, "Alex1");
        Analize.User user2 = new Analize.User(2, "Alex2");
        final List<Analize.User> prevList = List.of(user1, user2);
        Analize.User user5 = new Analize.User(5, "Alex5");
        Analize.User user6 = new Analize.User(6, "Alex6");
        List<Analize.User> currentList = List.of(user1, user2, user5, user6);
        assertEquals(2, analize.diff(prevList, currentList).added);
    }

    @Test
    public void whenDeleted2ElThen2() {
        Analize analize = new Analize();
        Analize.User user1 = new Analize.User(1, "Alex1");
        Analize.User user2 = new Analize.User(2, "Alex2");
        Analize.User user3 = new Analize.User(3, "Alex3");
        Analize.User user4 = new Analize.User(4, "Alex4");
        final List<Analize.User> prevList = List.of(user1, user2, user3, user4);
        final List<Analize.User> currentList = List.of(user1, user3);
        assertEquals(2, analize.diff(prevList, currentList).deleted);
    }

    @Test
    public void whenChanged2Of4ElementsThenDiffer2() {
        Analize analize = new Analize();

        Analize.User user1 = new Analize.User(1, "Alex1");
        Analize.User user2 = new Analize.User(2, "Alex2");
        Analize.User user3 = new Analize.User(3, "Alex3");
        Analize.User user4 = new Analize.User(4, "Alex4");
        final List<Analize.User> prevList = List.of(user1, user2, user3, user4);

        Analize.User user8 = new Analize.User(3, "newName");
        Analize.User user7 = new Analize.User(4, "Alex7");
        final List<Analize.User> currentList = List.of(user1, user2, user7, user8);

        assertEquals(2, analize.diff(prevList, currentList).changed);
    }
}
