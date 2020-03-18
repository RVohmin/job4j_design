package ru.job4j.design.lsp;

/**
 * @author RVohmin
 * @since 17.03.2020
 */
public interface Box {
    void add(Food food);
    boolean check(Food food);
}
