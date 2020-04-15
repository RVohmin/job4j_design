package ru.job4j.list;

import java.util.*;

/**
 * job4j_design ru.job4j.list.SimpleArray
 *
 * @author romanvohmin
 * @since 15.04.2020 19:37
 */
public class SimpleArray<T> implements Iterable<T> {
    int length = 10;
    Object[] array = new Object[length];
    int modCount = 0;
    int size = 0;

    public T get(int index) {
        if (size == 0 || index < 0 || index > array.length || index >= size) {
            throw new NoSuchElementException();
        }
        return (T) array[index];
    }

    public void add(T model) {
        if (size == length - 1) {
            array = Arrays.copyOf(array, (length * 3) / 2 + 1);
            length = (length * 3) / 2 + 1;
        }
        array[size] = model;
        modCount++;
        size++;

    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int position = 0;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return position < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) array[position++];
            }
        };
    }

    public static void main(String[] args) {
        SimpleArray<Integer> array = new SimpleArray<Integer>();
        for (int i = 1; i <= 40; i++) {
            array.add(i);
        }
        for (int i = 0; i < 40; i++) {
            System.out.println(array.get(i));
        }
        System.out.println("length: " + array.length);
    }
}
