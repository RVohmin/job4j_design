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

    int counter = 0;
    boolean checkEven;
    int value;

    public EvenNumbersIterator(int[] array) {
        this.array = array;
    }

    private void loop(int ind) {
        counter = ind;
        checkEven = false;
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
        if (!checkEven) {
            throw new NoSuchElementException("No more even elements");
        }
        return value;
    }
}
