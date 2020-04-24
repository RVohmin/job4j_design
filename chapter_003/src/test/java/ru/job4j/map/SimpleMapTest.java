package ru.job4j.map;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleMapTest {
    @Test
    public void whenAddOneElementThenTrueAndSizeOne() {
        SimpleMap<String, String> map = new SimpleMap<>();
        map.insert("a", "111");
        assertEquals(1, map.getSize());
    }

    @Test
    public void whenAddOneElementThenTrue() {
        SimpleMap<String, String> map = new SimpleMap<>();
        assertTrue(map.insert("a", "111"));
    }

    @Test
    public void whenAddExistKeyElementThenNotInsert() {
        SimpleMap<String, String> map = new SimpleMap<>();
        map.insert("a", "111");
        map.insert("a", "111");
        assertEquals(1, map.getSize());
    }

    @Test
    public void whenAddElementsThenGetIt() {
        SimpleMap<String, String> map = new SimpleMap<>();
        map.insert("a", "111");
        map.insert("b", "222");
        map.insert("c", "333");
        assertEquals("111", map.get("a"));
        assertEquals("222", map.get("b"));
        assertEquals("333", map.get("c"));
    }

    @Test
    public void whenAddElementsToOneIndexThenStoredInOneIndex() {
        SimpleMap<String, String> map = new SimpleMap<>();
        map.insert("a", "111");
        map.insert("1", "222");
        map.insert("aa ", "333");
        assertEquals(1, map.getBucketForTests("a"));
        assertEquals(1, map.getBucketForTests("1"));
        assertEquals(1, map.getBucketForTests("aa "));
        assertEquals(3, map.getSize());
        assertEquals("111", map.get("a"));
        assertEquals("222", map.get("1"));
        assertEquals("333", map.get("aa "));
    }

    @Test
    public void whenDeleteFromLinkedBucket() {
        SimpleMap<String, String> map = new SimpleMap<>();
        map.insert("a", "111");
        map.insert("1", "222");
        map.insert("aa ", "333");
        assertEquals(1, map.getBucketForTests("a"));
        assertEquals(1, map.getBucketForTests("1"));
        assertEquals(1, map.getBucketForTests("aa "));
        map.delete("1");
        System.out.println(map);
        assertEquals(2, map.getSize());
        assertEquals("111", map.get("a"));
        assertNull(map.get("1"));
    }

    @Test
    public void whenDeleteElementAndGetThenNull() {
        SimpleMap<String, String> map = new SimpleMap<>();
        map.insert("a", "111");
        map.insert("b", "222");
        map.insert("c", "333");
        assertEquals(3, map.getSize());
        map.delete("b");
        assertEquals(2, map.getSize());
        assertNull(map.get("b"));
    }
}
