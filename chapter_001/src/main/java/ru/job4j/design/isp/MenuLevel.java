package ru.job4j.design.isp;

/**
 * @author RVohmin
 * @since 19.03.2020
 */
public class MenuLevel implements PrintMenuLevel {
    String name;
    int level;

    public MenuLevel() {
    }

    public MenuLevel(String name, int level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public String printlevel() {
        return name + " " + level + ".";
    }
}
