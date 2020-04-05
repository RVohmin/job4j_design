package ru.job4j.collections.generic;

/**
 * job4j_design ru.job4j.collections.generic.Base
 *
 * @author romanvohmin
 * @version 1
 * @since 05.04.2020 06:45
 */
public abstract class Base {
    private final String id;

    protected Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
