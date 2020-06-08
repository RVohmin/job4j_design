package ru.job4j.cache;

import org.junit.Test;

import static org.junit.Assert.*;

public class SoftCacheTest {

    @Test
    public void whenGetText() {
        SoftCache softCache = new SoftCache();
        softCache.clearCache();
        String expected = "Вася, Петя";
        String actual = softCache.getText("Names.txt").trim();
        assertEquals(expected, actual);
    }

    @Test
    public void whenNotInCache() {
        SoftCache softCache = new SoftCache();
        softCache.clearCache();
        boolean expectedInCache = softCache.isInCache("Names.txt");
        assertFalse(expectedInCache);
    }

    @Test
    public void whenInCache() {
        SoftCache softCache = new SoftCache();
        softCache.getText("Names.txt");
        boolean expectedInCache = softCache.isInCache("Names.txt");
        assertTrue(expectedInCache);
    }
}