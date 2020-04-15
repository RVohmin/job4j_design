package ru.job4j.generic;

/**
 * job4j_design ru.job4j.generic.RoleStore
 *
 * @author romanvohmin
 * @version 1
 * @since 10.04.2020 15:56
 */
public class RoleStore<Store> extends AbstractStore<Role> {

    public RoleStore() {
        super(new SimpleArray<>(10));
    }
}
