package ru.job4j.collections.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ru.job4j.collections.iterator.IvenNumbersIterator
 *
 * @author romanvohmin
 * @since 03.04.2020
 */
public class EvenNumbersIterator implements Iterator {
    int[] array;
    int index = 0;
    int next = 0;
    int counter = 0;
    boolean checkEven;
    int value;

    public EvenNumbersIterator(int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        next = index;
        while (next < array.length) {
            if (array[next] % 2 == 0) {
                return true;
            }
            next++;
        }
        return false;
    }

    @Override
    public Object next() {
        while (index < array.length) {
            if (array[index] % 2 == 0) {
                return array[index++];
            }
            index++;
        }
        throw new NoSuchElementException("No more even elements");
    }
}
