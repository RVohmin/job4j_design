package ru.job4j.list;

/**
 * job4j_design ru.job4j.list.SimpleQueue
 *
 * @author romanvohmin
 * @since 18.04.2020 00:19
 */
public class SimpleQueue<T> {
    private final MyLinkedList<T> linkedList = new MyLinkedList<>();

    public T poll() {
        T temp = linkedList.getFirst().value;
        linkedList.deleteFirst();
        return temp;
    }

    public void push(T value) {
        linkedList.add(value);
    }

    public int getSise() {
        return linkedList.size();
    }
}
