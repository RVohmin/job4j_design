package ru.job4j.collections.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ru.job4j.collections.generic.SimpleArray Универсальная обертка над массивом
 *
 * @author romanvohmin
 * @since 04.04.2020
 */
public class SimpleArray<T> implements Iterable<T> {
    private final Object[] array;
    private int size = 0;

    public Object[] getArray() {
        return array;
    }

    public SimpleArray(int cells) {
        this.array = new Object[cells];
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
        if (index >= 0 && index < size && size < array.length) {
            array[index] = model;
        }
    }

    public void remove(int index) {
        if (index >= 0 && index < size) {
            System.arraycopy(array, index + 1, array, index, array.length - index - 1);
        }
        array[size - 1] = null;
        size--;
    }

    public T get(int index) {
        if (index >= 0 && index < array.length) {
            return (T) array[index];
        }
        throw new ArrayIndexOutOfBoundsException("index out of bounds array");
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int position = 0;

            @Override
            public boolean hasNext() {
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
}
