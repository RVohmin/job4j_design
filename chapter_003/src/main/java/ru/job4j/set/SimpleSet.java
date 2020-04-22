package ru.job4j.set;

import ru.job4j.list.SimpleArray;

import java.util.Iterator;

/**
 * job4j_design ru.job4j.set.SimpleSet
 *
 * @author romanvohmin
 * @since 20.04.2020 23:27
 */
public class SimpleSet<E> implements Iterable<E> {
    private final SimpleArray<E> set = new SimpleArray<>();

    public E getByIndex(int index) {
        return set.getByIndex(index);
    }

    public void add(E model) {
        if (!contains(model)) {
            set.add(model);

        }
    }

    public int getSize() {
        return set.getSize();
    }

    private boolean contains(E e) {
        for (E item : set) {
            if (item == e) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return set.iterator();
    }
}
