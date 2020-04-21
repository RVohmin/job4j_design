package ru.job4j.generic;

import java.util.NoSuchElementException;

/**
 * job4j_design ru.job4j.generic.AbstractStore
 *
 * @author romanvohmin
 * @since 15.04.2020 15:57
 */
public class AbstractStore<T extends Base> implements Store<T> {
    SimpleArray<T> store;

    public AbstractStore(SimpleArray<T> store) {
        this.store = store;
    }

    @Override
    public void add(T model) {
        this.store.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = getIndexById(id);
        if (index != -1) {
            store.set(index, model);
        }
        return index != -1;
    }

    @Override
    public boolean delete(String id) {
        int index = getIndexById(id);
        if (index != -1) {
            store.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        int index = getIndexById(id);
        if (index == -1) {
            throw new NoSuchElementException("Out of Bound array");
        }
        return store.get(index);
    }

    private int getIndexById(String id) {
        int result = -1;
        for (int index = 0; index <= store.getSize(); index++) {
            if (store.get(index).getId().equals(id)) {
                result = index;
                break;
            }
        }
        return result;
    }
}
