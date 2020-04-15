package ru.job4j.generic;

import org.junit.Test;

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


        simpleArray.remove(2);

        assertThat(new Integer[]{1, 2, 4, 5, null}, is(simpleArray.getArray()));
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
}
