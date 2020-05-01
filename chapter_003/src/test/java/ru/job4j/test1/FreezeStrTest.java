package ru.job4j.test1;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FreezeStrTest {
    @Test
    public void whenEq() {
        assertTrue(FreezeStr.eq("Hello", "Hlloe"));
    }

    @Test
    public void whenNotEq() {
        assertFalse(FreezeStr.eq("Hello", "Halle"));
    }

    @Test
    public void whenNotMultiEq() {
        assertFalse(FreezeStr.eq("heloo", "hello"));
    }

}
