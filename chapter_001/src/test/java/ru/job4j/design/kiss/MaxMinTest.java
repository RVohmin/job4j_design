package ru.job4j.design.kiss;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class MaxMinTest {


    @Test
    public void thenMin5ThenTrue() {
        List<Integer> list = List.of(79, 69, 49, 19, 5, 22, 34, 5, 66);
        MaxMin obj = new MaxMin();
        Integer expected = 5;
        Integer rsl = obj.min(list, Integer::compareTo);
        assertEquals(rsl, expected);
    }

    @Test
    public void thenMinIsMinus5ThenTrue() {
        List<Integer> list = List.of(79, 69, 49, 19, -5, 22, 34, 5, 66);
        MaxMin obj = new MaxMin();
        Integer expected = -5;
        Integer rsl = obj.min(list, Integer::compareTo);
        assertEquals(rsl, expected);
    }

    @Test
    public void thenMax99ThenTrue() {
        List<Integer> list = List.of(-99, -7, 17, 17, 49, 99, 79, 69, 49, 19, 5, 22, 34, 5, 66);
        MaxMin obj = new MaxMin();
        Integer expected = 99;
        Integer rsl = obj.max(list, Integer::compareTo);
        assertEquals(rsl, expected);
    }

    @Test
    public void thenMax100ThenTrue() {
        List<Integer> list = List.of(79, 69, 49, 19, 5, 22, 34, 5, 66, 100);
        MaxMin obj = new MaxMin();
        Integer expected = 100;
        Integer rsl = obj.max(list, Integer::compareTo);
        assertEquals(rsl, expected);
    }

}
