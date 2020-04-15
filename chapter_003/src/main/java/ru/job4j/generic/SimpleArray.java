package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ru.job4j.generic.SimpleArray Универсальная обертка над массивом
 *
 * @author romanvohmin
 * @since 04.04.2020
 */
public class SimpleArray<E> implements Iterable<E> {
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

    public void add(E model) {
        if (size >= array.length) {
            throw new IllegalStateException("There are no free cells");
        }
        array[size] = model;
        size++;
    }

    public void set(int index, E model) {
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

    public E get(int index) {
        if (index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException("index out of bounds array");
        }
        return (E) array[index];
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int position = 0;

            @Override
            public boolean hasNext() {
                return position < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) array[position++];
            }
        };
    }
}
