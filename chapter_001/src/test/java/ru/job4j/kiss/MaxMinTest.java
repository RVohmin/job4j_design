package ru.job4j.kiss;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class MaxMinTest {
    List<Integer> list = List.of(79, 69, 49, 19, 22, 34, 5, 66);
    MaxMin obj = new MaxMin();

    @Test
    public void thenMin5ThenTrue() {
        Integer expected = 5;
        Integer rsl = obj.min(list, Integer::compareTo);
        assertThat(expected, is(rsl));
    }

    @Test
    public void thenMax79ThenTrue() {
        Integer expected = 79;
        Integer rsl = obj.max(list, Integer::compareTo);
        assertThat(expected, is(rsl));
    }

}
