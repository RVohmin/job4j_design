package ru.job4j.list;

import java.util.*;

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
    private Object[] array = new Object[length];
    private int modCount = 0;
    private int size = 0;

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new NoSuchElementException();
        }
        return (T) array[index];
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
            private int position = 0;
            private final int expectedModCount = modCount;

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

    public int getSize() {
        return array.length;
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
            System.out.println(array.get(i));
        }
        System.out.println("length: " + array.getSize());
    }
}
