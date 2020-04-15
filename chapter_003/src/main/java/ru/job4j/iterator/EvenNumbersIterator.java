package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ru.job4j.iterator.IvenNumbersIterator
 *
 * @author romanvohmin
 * @since 03.04.2020
 */
public class EvenNumbersIterator implements Iterator<Integer> {
    int[] array;
    int index = 0;

    public EvenNumbersIterator(int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        boolean temp = false;
        for (int i = index; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                temp = true;
                index = i;
                break;
            }
        }
        return temp;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more even elements");
        }
        return array[index++];
    }
}
