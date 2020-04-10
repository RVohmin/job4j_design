package ru.job4j.collections.generic;

/**
 * job4j_design ru.job4j.collections.generic.UserStore
 *
 * @author romanvohmin
 * @version 1
 * @since 05.04.2020 06:58
 */
public class UserStore<T extends Base> implements Store<T> {
    SimpleArray<T> userStore;

    public UserStore(SimpleArray<T> userStore) {
        this.userStore = userStore;
    }

    @Override
    public void add(T model) {
        this.userStore.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = getIndexById(id);
        if (index != -1) {
            userStore.set(index, model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        int index = getIndexById(id);
        if (index != -1) {
            userStore.remove(index);
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
        for (int index = 0; index <= userStore.getSize(); index++) {
            if (userStore.get(index).getId().equals(id)) {
                result = index;
                break;
            }
        }
        return result;
    }
}
