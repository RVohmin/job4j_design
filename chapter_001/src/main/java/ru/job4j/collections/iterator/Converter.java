package ru.job4j.collections.iterator;

import java.util.Iterator;

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

            private void isCheck() {
                while (!subIter.hasNext() && it.hasNext()) {
                    subIter = it.next();
                }
            }

            @Override
            public boolean hasNext() {
                isCheck();
                return subIter.hasNext();
            }

            @Override
            public Integer next() {
                isCheck();
                return subIter.next();
            }
        };
    }
}
