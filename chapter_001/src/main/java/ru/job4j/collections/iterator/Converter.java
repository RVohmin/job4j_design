package ru.job4j.collections.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ru.job4j.collections.iterator.Converter
 *
 * @author romanvohmin
 * @since 03.04.2020
 */
public class Converter {
    Iterator<Integer> subIter;

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {

        if (it.hasNext()) {
            subIter = it.next();
        }

        return new Iterator<>() {

            @Override
            public boolean hasNext() {
                while (!subIter.hasNext() && it.hasNext()) {
                    subIter = it.next();
                }
                return subIter.hasNext();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return subIter.next();
            }
        };
    }
}
