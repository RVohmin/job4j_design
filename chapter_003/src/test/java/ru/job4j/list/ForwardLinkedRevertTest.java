package ru.job4j.list;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class ForwardLinkedRevertTest {
    @Test
    public void whenAddThenIter() {
        ForwardLinkedRevert<Integer> linked = new ForwardLinkedRevert<>();
        linked.add(1);
        linked.add(2);
        linked.add(3);

        Iterator<Integer> it = linked.iterator();
        assertEquals(1, (int) it.next());
        assertEquals(2, (int) it.next());
        assertEquals(3, (int) it.next());

    }

    @Test
    public void whenAddAndRevertThenIter() {
        ForwardLinkedRevert<Integer> linked = new ForwardLinkedRevert<>();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);
        linked.add(5);


        linked.revert();
        Iterator<Integer> it = linked.iterator();
        assertEquals(5, (int) it.next());
        assertEquals(4, (int) it.next());
        assertEquals(3, (int) it.next());
        assertEquals(2, (int) it.next());
        assertEquals(1, (int) it.next());
    }

}
