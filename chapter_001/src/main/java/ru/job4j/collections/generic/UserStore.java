package ru.job4j.collections.generic;

/**
 * job4j_design ru.job4j.collections.generic.UserStore
 *
 * @author romanvohmin
 * @version 1
 * @since 05.04.2020 06:58
 */
public class UserStore implements Store {
    SimpleArray<User> userStore;

    public UserStore(SimpleArray<User> userStore) {
        this.userStore = userStore;
    }

    @Override
    public void add(Base model) {

    }

    @Override
    public boolean replace(String id, Base model) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Base findById(String id) {
        return null;
    }
}
