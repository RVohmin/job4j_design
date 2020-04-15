package ru.job4j.generic;

/**
 * ru.job4j.generic.Store
 *
 * @author romanvohmin
 * @since 05.04.2020
 */
public interface Store<T extends Base> {
    void add(T model);

    boolean replace(String id, T model);

    boolean delete(String id);

    T findById(String id);
}
