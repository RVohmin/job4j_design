package ru.job4j.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * job4j_design ru.job4j.collections.list.ForwardLinked
 *
 * @author romanvohmin
 * @since 14.04.2020 09:11
 */
public class ForwardLinkedRevert<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> newNode = new Node<>(value, null);
        if (head == null) {
            head = newNode;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = newNode;
    }

    public void revert() {
        Node<T> prevNode = null;
        Node<T> currentNode = head;
        Node<T> nextNode = head.next;

        while (nextNode != null) {
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
            nextNode = currentNode.next;
        }
        currentNode.next = prevNode;
        head = currentNode;
    }

    public void deleteFirst() {
        Node<T> temp = head;
        if (head == null) {
            throw new NoSuchElementException();
        }
        head = temp.next;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;


        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ForwardLinkedRevert<Integer> linked = new ForwardLinkedRevert<>();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        System.out.println(linked);
        for (Integer item : linked) {
            System.out.println(item);
        }
    }
}
