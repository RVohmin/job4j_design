package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class MyLinkedListTest {
    MyLinkedList<Float> list = new MyLinkedList<>();
    Iterator<Float> iterator = list.iterator();

    @Before
    public void initialize() {
        list.add(1f);
        list.add(2f);
        list.add(3f);
        list.add(4f);
        list.add(5f);
    }

    @Test
    public void whenAdd6ThenGet6() {
        list.add(6f);
        assertEquals(6f, list.get(5), 0.01);
    }

    @Test
    public void whenGetForIndexThenReturnValue() {
        assertEquals(3f, list.get(2), 0.001);
        assertEquals(5f, list.get(4), 0.001);
    }

    @Test
    public void whenGetSizeThenReturnSizeList() {
        assertEquals(5, list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetIndexOutOfBoundThenExcepted() {
        list.get(5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenListEmptyAndGetFirstThenIndexOutOfBoundThenExcepted() {
        list.clear();
        list.get(0);
    }

    @Test
    public void whenClearThenListSizeNull() {
        list.clear();
        assertEquals(0, list.size());
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenAddInIterationThenException() {
        while (iterator.hasNext()) {
            list.add(7f);
            iterator.next();
        }
    }

    @Test
    public void remove() {
        list.remove(2);
        assertEquals(1f, list.get(0), 0.001);
        assertEquals(2f, list.get(1), 0.001);
        assertEquals(4f, list.get(2), 0.001);
        assertEquals(5f, list.get(3), 0.001);
        assertEquals(4, list.size());
    }

    @Test
    public void whenRemoveSecondOfTwoElements() {
        list.clear();
        list.add(1f);
        list.add(2f);
        list.remove(1);
        assertEquals(1f, list.get(0), 0.001);
        assertEquals(1, list.size());
    }
    @Test
    public void whenOneElementAndRemove() {
        list.clear();
        list.add(1f);
        list.remove(0);
        assertEquals(0, list.size());
    }

    @Test
    public void whenOneFromTwoElementAndRemoveWithIter() {
        list.clear();
        list.add(1f);
        list.remove(0);
        assertEquals(0, list.size());
    }
}
