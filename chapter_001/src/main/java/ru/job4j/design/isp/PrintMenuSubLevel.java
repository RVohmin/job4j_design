package ru.job4j.design.isp;

/**
 * @author RVohmin
 * @since 19.03.2020
 */
public interface PrintMenuSubLevel extends PrintMenuLevel {
    String addSubLevel(MenuLevel menuLevel);
}
