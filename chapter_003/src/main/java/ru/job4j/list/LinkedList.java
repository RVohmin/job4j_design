//package ru.job4j.list;
//
//import java.util.Arrays;
//import java.util.ConcurrentModificationException;
//import java.util.Iterator;
//import java.util.NoSuchElementException;
//
///**
// * job4j_design ru.job4j.list.SimpleArray
// *
// * @author romanvohmin
// * @since 15.04.2020 19:37
// */
//public class LinkedList<T> implements Iterable<T> {
//    private Node<T> head;
//    int modCount = 0;
//    int size = 0;
//
//    private static class Node<T> {
//        T value;
//        Node<T> next;
//        Node<T> prev;
//
//
//        public Node(T value, Node<T> next) {
//            this.value = value;
//            this.next = next;
//        }
//    }
//    public T get(int index) {
//        Node<T> tail = head;
//        while (tail.next != null) {
//            tail = tail.next;
//        }
//        tail.next = node;
//        return (T) array[index];
//    }
//    public void add(T model) {
//        Node<T> node = new Node<>(model, null);
//        if (head == null) {
//            head = node;
//            return;
//        }
//        Node<T> tail = head;
//        while (tail.next != null) {
//            tail = tail.next;
//        }
//        tail.next = node;
//        if (size == length - 1) {
//            array = Arrays.copyOf(array, (length * 3) / 2 + 1);
//            length = (length * 3) / 2 + 1;
//        }
//
//        Node<T> head = new LinkedList.Node<T>(model, null);
//
//        array[size] = node;
//        modCount++;
//        size++;
//
//    }
//
//    @Override
//    public Iterator<T> iterator() {
//        return new Iterator<>() {
//            int position = 0;
//            int expectedModCount = modCount;
//
//            @Override
//            public boolean hasNext() {
//                if (expectedModCount != modCount) {
//                    throw new ConcurrentModificationException();
//                }
//                return position < size;
//            }
//
//            @Override
//            public T next() {
//                if (!hasNext()) {
//                    throw new NoSuchElementException();
//                }
//                return (T) array[position++];
//            }
//        };
//    }
//
//
//
//    public static void main(String[] args) {
//        LinkedList<Integer> array = new LinkedList<Integer>();
//        for (int i = 1; i <= 40; i++) {
//            array.add(i);
//        }
//        for (int i = 0; i < 40; i++) {
//            System.out.println(array.get(i));
//        }
//        System.out.println("length: " + array.length);
//    }
//}
