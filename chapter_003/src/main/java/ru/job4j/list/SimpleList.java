package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * job4j_design ru.job4j.list.SimpleArray
 *
 * @author romanvohmin
 * @since 15.04.2020 19:37
 */
public class SimpleList<T> implements Iterable<T> {
    private Node<T> first;
    private Node<T> last;
    private int modCount = 0;
    private int size = 0;

    public static class Node<T> {
        T value;
        Node<T> next;
        Node<T> previous;

        public Node(T value) {
            this.value = value;
        }
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (first == null) {
            newNode.next = null;
            newNode.previous = null;
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            newNode.previous = last;
            last = newNode;
        }
        size++;
        modCount++;
    }

    public T remove(int index) {
        T removedValue;
        if (index < 0 || index >= size) {
            throw new NoSuchElementException();
        }
        if (size == 1) {
            removedValue = first.value;
            clear();
            return removedValue;
        }
        if (index == size - 1) {
            return deleteLast();
        }
        if (index == 0) {
            return deleteFirst();
        }
        Node<T> node = first;
        int count = 0;
        while (node.next != null) {
            if (count == index) {
                removedValue = node.value;
                node.previous.next = node.next;
                node.next.previous = node.previous;
                size--;
                modCount++;
                return removedValue;
            }
            node = node.next;
            count++;
        }
        return null;
    }

    public T deleteLast() {
        T valueLast = last.value;
        if (size == 1) {
            clear();
            return valueLast;
        }
        last = last.previous;
        last.next = null;
        size--;
        modCount++;
        return valueLast;
    }

    public T deleteFirst() {
        T valueFirst = first.value;
        if (size == 1) {
            clear();
            return valueFirst;
        }
        first = first.next;
        first.previous = null;
        size--;
        modCount++;
        return valueFirst;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new NoSuchElementException();
        }
        Node<T> result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.value;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
        modCount++;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        final int expectedModCount = modCount;
        return new Iterator<>() {
            Node<T> node = first;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    @Override
    public String toString() {
        Node<T> node = first;
        Object[] arr = new Object[size];
        for (int i = 0; i < size; i++) {
            arr[i] = node.value;
            node = node.next;
        }
        return Arrays.toString(arr);
    }
}
