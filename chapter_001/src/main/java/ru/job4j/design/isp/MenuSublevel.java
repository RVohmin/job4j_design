package ru.job4j.design.isp;

/**
 * @author RVohmin
 * @since 19.03.2020
 */
public class MenuSublevel extends MenuLevel implements PrintMenuSubLevel {
    int count = 1;

    public MenuSublevel(MenuLevel menuLevel) {
    }

    @Override
    public String addSubLevel(MenuLevel menuLevel) {
        return "---- " + menuLevel.printlevel() + count++ + ".";
    }
}
