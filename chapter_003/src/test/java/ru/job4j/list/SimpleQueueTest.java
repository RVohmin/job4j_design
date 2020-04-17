package ru.job4j.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleQueueTest {
    SimpleQueue<Integer> queue = new SimpleQueue<>();

    @Test
    void poll() {
        queue.push(1);
        queue.push(3);
        queue.push(5);
        assertEquals(1, queue.poll());
        assertEquals(3, queue.poll());
        assertEquals(5, queue.poll());
    }

    @Test
    void push() {
        queue.push(1);
        queue.push(3);
        queue.push(5);
        assertEquals(3, queue.getSise());
    }
}
