package ru.job4j.list;

/**
 * job4j_design ru.job4j.list.SimpleQueue
 *
 * @author romanvohmin
 * @since 18.04.2020 00:19
 */
public class SimpleQueue<T> {
    private final SimpleList<T> list = new SimpleList<>();

    public T poll() {
        return list.deleteFirst();
    }

    public void push(T value) {
        list.add(value);
    }

    public int size() {
        return list.size();
    }
}
