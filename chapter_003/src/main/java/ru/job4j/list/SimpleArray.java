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
public class SimpleArray<T> implements Iterable<T> {
    /**
     * length - задает начальную длину массива, которая увеличивается при заполнении массива в 1,5 раза
     */
    private int length = 10;
    private T[] array = (T[]) new Object[length];
    private int modCount = 0;
    private int size = 0;

    public T getByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new NoSuchElementException();
        }
        return array[index];
    }

    public void add(T model) {
        increase();
        array[size] = model;
        modCount++;
        size++;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int index = 0;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return index < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[index++];
            }
        };
    }

    public int getSize() {
        return size;
    }

    private void increase() {
        if (size == length - 1) {
            array = Arrays.copyOf(array, (length * 3) / 2 + 1);
            length = (length * 3) / 2 + 1;
        }
    }

    public static void main(String[] args) {
        SimpleArray<Integer> array = new SimpleArray<>();
        for (int i = 1; i <= 40; i++) {
            array.add(i);
        }
        for (int i = 0; i < 40; i++) {
            System.out.println(array.getByIndex(i));
        }
        System.out.println("length: " + array.getSize());
    }
}
