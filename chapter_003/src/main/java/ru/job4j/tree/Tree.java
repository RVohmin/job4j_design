package ru.job4j.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

/**
 * job4j_design ru.job4j.tree.Tree
 *
 * @author romanvohmin
 * @since 25.04.2020 15:13
 */
public class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> el = findBy(parent);
        if (el.isEmpty()) {
            System.out.println("Нет такого родительского узла  - " + parent);
            return false;
        }
        if (findBy(child).isPresent()) {
            System.out.println("Элемент уже существует - " + child);
            return false;
        }
        el.get().children.add(new Node<>(child));
        return true;
    }

    public boolean isBinary() {
        Queue<Node<E>> list = new LinkedList<>();
        list.offer(root);
        while (!list.isEmpty()) {
            Node<E> el = list.poll();
            if (el.children.size() > 2) {
                return false;
            }
            list.addAll(el.children);
        }
        return true;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}
