package ru.job4j.generic;

/**
 * job4j_design ru.job4j.generic.UserStore
 *
 * @author romanvohmin
 * @version 1
 * @since 05.04.2020 06:58
 */
public class UserStore<Store> extends AbstractStore<User> {
    SimpleArray<User> userStore;

    public UserStore() {
        super(new SimpleArray<>(10));
    }
}
