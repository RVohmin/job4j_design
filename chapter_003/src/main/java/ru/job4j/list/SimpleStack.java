package ru.job4j.list;

import org.w3c.dom.Node;

/**
 * job4j_design ru.job4j.list.SimpleStack
 *
 * @author romanvohmin
 * @since 17.04.2020 23:32
 */
public class SimpleStack<T> {
    private final MyLinkedList<T> linked = new MyLinkedList<>();

    public T poll() {
        T temp;
        temp = linked.getLast().value;
        linked.deleteLast();
        return temp;
    }

    public void push(T value) {
        linked.add(value);
    }
}
