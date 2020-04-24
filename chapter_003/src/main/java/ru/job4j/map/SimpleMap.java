package ru.job4j.map;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * job4j_design ru.job4j.map.SimpleHashMap
 *
 * @author romanvohmin
 * @since 23.04.2020 22:01
 */
public class SimpleMap<K, V> implements Iterable<SimpleMap.Node<K, V>> {
    private Node<K, V>[] hashTable;
    private int capacity;
    private final float loadFactor;
    private int size;

    public SimpleMap() {
        this(16, 0.75f);
    }

    public SimpleMap(int capacity) {
        this(capacity, 0.75f);
    }

    public SimpleMap(int capacity, float loadFactor) {
        this.hashTable = new Node[capacity];
        this.loadFactor = loadFactor;
        this.capacity = capacity;
    }

    public int getSize() {
        return size;
    }

    public int getLength() {
        return hashTable.length;
    }

    boolean insert(K key, V value) {
        if (((float) size / hashTable.length) >= loadFactor) {
            resize();
        }
        int index = getIndexFor(key);
        Node<K, V> newNode = new Node<>(key, value, null, hash(key));
        Node<K, V> item = hashTable[index];
        if (item != null) {
            if (item.next != null) {
                while (item.next != null) {
                    if (newNode.hash == item.hash && (newNode.key == item.key || key.equals(item.key))) {
                        item.value = value;
                        return true;
                    }
                    item = item.next;
                }
            } else {
                if (newNode.hash == item.hash && (newNode.key == item.key || key.equals(item.key))) {
                    item.value = value;
                    return true;
                }
            }
            item.next = newNode;
            size++;
            return true;
        }
        hashTable[index] = newNode;
        size++;
        return true;
    }

    boolean insertToTargetTable(Node<K, V> node, Node<K, V>[] table) {
        int index = getIndexFor(node.key, table);
        Node<K, V> newNode = new Node<>(node.key, node.value, null, hash(node.key));
        Node<K, V> item = table[index];
        if (item != null) {
            if (item.next != null) {
                while (item.next != null) {
                    item = item.next;
                }
                item.next = newNode;
                size++;
                return true;
            } else {
                item.next = newNode;
                size++;
                return true;
            }
        }
        table[index] = newNode;
        size++;
        return true;
    }

    private int getIndexFor(K key) {
        return (hashTable.length - 1) & hash(key);
    }

    private int getIndexFor(K key, Node<K, V>[] table) {
        return (table.length - 1) & hash(key);
    }

    public int getBucketForTests(K key) {
        return getIndexFor(key);
    }

    V get(K key) {
        int index = getIndexFor(key);
        int hash = hash(key);
        Node<K, V> node = hashTable[index];
        if (node == null) {
            return null;
        } else if (node.next == null) {
            if (node.hash == hash && (node.key == key || node.key.equals(key))) {
                return node.value;
            } else {
                return null;
            }
        } else {
            while (node.next != null) {
                if (node.hash == hash && (node.key == key || node.key.equals(key))) {
                    return node.value;
                }
                node = node.next;
            }
            if (node.hash == hash && (node.key == key || node.key.equals(key))) {
                return node.value;
            }
        }
        return null;
    }

    Node<K, V> temp;

    boolean delete(K key) {
        int index = getIndexFor(key);
        int hash = hash(key);
        temp = hashTable[index];
        if (temp == null) {
            System.out.println("No such element");
            return false;
        }
        if (temp.next == null) {
            if (temp.hash == hash && (temp.key == key || temp.key.equals(key))) {
                hashTable[index] = null;
                size--;
                return true;
            } else {
                return false;
            }
        }
        Node<K, V> prev = null;
        while (temp.next != null) {
            if (temp.hash == hash && (temp.key == key || temp.key.equals(key))) {
                if (prev != null) {
                    prev.next = temp.next;
                    size--;
                    return true;
                } else {
                    temp = null;
                    size--;
                    return true;
                }
            }
            prev = temp;
            temp = temp.next;
        }
        if (temp.hash == hash && (temp.key == key || temp.key.equals(key))) {
            hashTable[index] = null;
            size--;
            return true;
        }
        return false;
    }

    private int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public void resize() {
        Node<K, V>[] newHashTable;
        size = 0;
        capacity = capacity * 2;
        newHashTable = new Node[capacity];
        for (Node<K, V> item : hashTable) {
            if (item == null) {
                continue;
            }
            if (item.next != null) {
                while (item.next != null) {
                    insertToTargetTable(item, newHashTable);
                    item = item.next;
//                        delete(item.key);
                }
            }
            insertToTargetTable(item, newHashTable);
        }
        hashTable = newHashTable;
    }

    @Override
    public Iterator<SimpleMap.Node<K, V>> iterator() {

        return new Iterator<>() {
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public Node<K, V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return hashTable[count++];
            }
        };
    }

    static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;
        final int hash;

        public Node(K key, V value, Node<K, V> next, int hash) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.hash = hash;
        }

        public final String toString() {
            return key + "=" + value;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(System.lineSeparator());
        for (Node<K, V> item : hashTable) {
            if (item == null) {
                continue;
            }
            stringBuilder.append(item.key).append(" = ").append(item.value);
            if (item.next != null) {
                while (item.next != null) {
                    item = item.next;
                    stringBuilder.append(", ");
                    stringBuilder.append(item.key).append(" = ").append(item.value).append(" ");
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        SimpleMap<String, String> map = new SimpleMap<>();
        map.insert("a", "111");
        map.insert("1", "222");
        map.insert("aa ", "333");
        map.insert("b", "333");
        map.insert("c", "333");
        map.insert("d", "333");
        map.insert("e", "333");
        map.insert("f", "333");
        map.insert("g", "333");
        map.insert("h", "333");
        map.insert("i", "333");
        map.insert("j", "333");
        map.insert("k", "333");

        System.out.println(map.getLength());
        System.out.println(map);
    }
}
