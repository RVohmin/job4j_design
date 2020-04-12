package ru.job4j.collections.list;

/**
 * job4j_design ru.job4j.collections.list.SimpleArrayList
 *
 * @author romanvohmin
 * @since 11.04.2020 15:24
 */
public class SimpleArrayList<E> {
    private int size;
    private Node<E> first;

    /**
     * Метод вставляет в начало списка данные.
     */
    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = first;
        first = newLink;
        size++;
    }

    /**
     * Реализовать метод удаления первого элемент в списке.
     */
    public void delete() {
        first.next = first;
        size--;
        return ;
    }

    /**
     * Метод получения элемента по индексу.
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    /**
     * Метод получения размера коллекции.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Класс предназначен для хранения данных.
     */
    private static class Node<E> {

        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }
}
