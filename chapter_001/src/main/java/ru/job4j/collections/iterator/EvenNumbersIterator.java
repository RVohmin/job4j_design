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

    private void loop(int ind) {
        this.counter = ind;
        checkEven = false;
        value = 1;
        while (counter < array.length) {
            if (array[counter] % 2 == 0) {
                checkEven = true;
                value = array[counter++];
                return;
            }
            counter++;
        }
    }

    @Override
    public boolean hasNext() {
        counter = index;
        loop(counter);
        return checkEven;
    }

    @Override
    public Integer next() {
        counter = index;
        loop(counter);
        index = counter;
        if (value == 1) {
            throw new NoSuchElementException("No more even elements");
        }
        return value;
    }
}
