package ru.job4j.tree;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TreeTest {
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertTrue(tree.findBy(6).isPresent());
        assertTrue(tree.findBy(5).isPresent());
    }

    @Test
    public void when6ElFindNotExistThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertFalse(tree.findBy(7).isPresent());
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(10);
        tree.add(10, 5);
        tree.add(10, 20);
        tree.add(5, 2);
        tree.add(5, 7);
        tree.add(20, 15);
        tree.add(20, 30);
        assertTrue(tree.isBinary());
        tree.add(20, 18);
        assertFalse(tree.isBinary());

    }
}
