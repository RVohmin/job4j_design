package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class SimpleSetTest {
    SimpleSet<Integer> set = new SimpleSet<>();

    @Before
    public void setUp() {
        set.add(1);
        set.add(2);
        set.add(3);
    }

    @Test
    public void get() {
        set.add(4);
        assertEquals(4, set.get(3));
    }

    @Test
    public void whenAddNotExistedValueThenAdd() {
        set.add(4);
        assertEquals(4, set.getSize());
    }

    @Test
    public void whenAddExistValueThenNotAdd() {
        set.add(3);
        set.add(3);
        assertEquals(3, set.getSize());
    }

    @Test
    public void getSize() {
        assertEquals(3, set.getSize());
    }

    @Test
    public void iterator() {
        Iterator<Integer> iterator = set.iterator();
        assertEquals((Integer) 1, iterator.next());
        assertEquals((Integer) 2, iterator.next());
        assertEquals((Integer) 3, iterator.next());
    }
}
