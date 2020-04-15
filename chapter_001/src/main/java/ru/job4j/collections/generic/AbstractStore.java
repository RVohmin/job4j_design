package ru.job4j.collections.generic;

/**
 * job4j_design ru.job4j.collections.generic.AbstractStore
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
            return true;
        }
        return false;
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
        return null;
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
