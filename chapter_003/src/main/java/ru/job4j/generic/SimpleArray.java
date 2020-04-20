package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ru.job4j.generic.SimpleArray Универсальная обертка над массивом
 *
 * @author romanvohmin
 * @since 04.04.2020
 */
public class SimpleArray<T> implements Iterable<T> {
    private final T[] array;
    private int size = 0;

    public T[] getArray() {
        return array;
    }

    public SimpleArray(int cells) {
        array = (T[]) new Object[cells];
    }

    public int getSize() {
        return array.length;
    }

    public void add(T model) {
        if (size >= array.length) {
            throw new IllegalStateException("There are no free cells");
        }
        array[size] = model;
        size++;
    }

    public void set(int index, T model) {
        if (index < 0 && index > size) {
            throw new IllegalStateException();
        }
        array[index] = model;
    }

    public void remove(int index) {
        if (index < 0 && index >= size) {
            throw new IllegalStateException();
        }
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
        array[size - 1] = null;
        size--;
    }

    public T get(int index) {
        if (index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException("index out of bounds array");
        }
        return array[index];
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int index = 0;

            @Override
            public boolean hasNext() {
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
}
