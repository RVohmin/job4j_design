package ru.job4j.list;

/**
 * job4j_design ru.job4j.list.SimpleStack
 *
 * @author romanvohmin
 * @since 17.04.2020 23:32
 */
public class SimpleStack<T> {
    private final SimpleList<T> linked = new SimpleList<>();

    public T poll() {
        return linked.deleteLast();
    }

    public void push(T value) {
        linked.add(value);
    }

    public int size() {
        return linked.size();
    }
}
