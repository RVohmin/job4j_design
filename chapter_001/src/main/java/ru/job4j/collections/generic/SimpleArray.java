package ru.job4j.collections.generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ru.job4j.collections.generic.SimpleArray Универсальная обертка над массивом
 *
 * @author romanvohmin
 * @since 04.04.2020
 */
public class SimpleArray<T> implements Iterable<T> {
    private Object[] array;
    private int index = 0;

    public Object[] getArray() {
        return array;
    }

    public SimpleArray(int cells) {
        this.array = new Object[cells];
    }

    private void checkArrayIndex(int index) {
        if (index >= array.length) {
            throw new ArrayIndexOutOfBoundsException("Index out of array bounds");
        }
    }

    public void add(T model) {
        boolean success = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = model;
                success = true;
                break;
            }
        }
        if (!success) {
            throw new IllegalStateException("There are no free cells");
        }
    }

    public void set(int index, T model) {
        checkArrayIndex(index);
        array[index] = model;
    }

    public void remove(int index) {
        checkArrayIndex(index);
        System.arraycopy(array, index + 1, array, index, array.length - 1 - index);
        array[array.length - 1] = null;
    }

    public T get(int index) {
        checkArrayIndex(index);
        return (T) array[index];
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int position = 0;

            @Override
            public boolean hasNext() {
                return position < array.length;
            }

            @Override
            @SuppressWarnings("unchecked")
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) array[position++];
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleArray)) return false;
        SimpleArray<?> that = (SimpleArray<?>) o;
        return Arrays.equals(getArray(), that.getArray());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getArray());
    }
}
