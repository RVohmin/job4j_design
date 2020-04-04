package ru.job4j.collections.generic;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {

    @Test
    public void whenAdd5ThenFirstCellIs5() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(1);
        int result = simpleArray.get(0);
        assertThat(result, is(1));
    }

    @Test
    public void set() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(2);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.set(1, 3);
        int result = simpleArray.get(1);
        assertThat(result, is(3));
    }

    @Test
    public void remove() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        simpleArray.add(5);

        SimpleArray<Integer> simpleArray2 = new SimpleArray<>(5);
        simpleArray2.add(1);
        simpleArray2.add(2);
        simpleArray2.add(4);
        simpleArray2.add(5);
        simpleArray.remove(2);
        assertEquals(simpleArray2, simpleArray);
    }

    @Test
    public void get() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(2);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.remove(1);
        int result = simpleArray.get(0);
        assertThat(result, is(1));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenSetIndexOutOfBoundsThenException() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(2);
        simpleArray.set(2, 2);
    }
}