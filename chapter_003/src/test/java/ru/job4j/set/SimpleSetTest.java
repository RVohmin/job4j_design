package ru.job4j.set;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class SimpleSetTest {

    @Test
    public void get() {
        SimpleSet<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        assertEquals((Integer) 4, set.getByIndex(3));
    }

    @Test
    public void whenAddNotExistedValueThenAdd() {
        SimpleSet<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(4);
        assertEquals(4, set.getSize());
    }

    @Test
    public void whenAddExistValueThenNotAdd() {
        SimpleSet<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(3);
        set.add(3);
        assertEquals(3, set.getSize());
    }

    @Test
    public void getSize() {
        SimpleSet<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        assertEquals(3, set.getSize());
    }

    @Test
    public void iterator() {
        SimpleSet<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        Iterator<Integer> iterator = set.iterator();
        assertEquals((Integer) 1, iterator.next());
        assertEquals((Integer) 2, iterator.next());
        assertEquals((Integer) 3, iterator.next());
    }
}
