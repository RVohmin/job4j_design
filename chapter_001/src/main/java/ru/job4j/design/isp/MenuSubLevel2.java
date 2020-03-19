package ru.job4j.design.isp;

/**
 * @author RVohmin
 * @since 19.03.2020
 */
public class MenuSubLevel2 implements PrintMenuSublevel2 {
    int count = 1;

    public MenuSubLevel2(MenuSublevel menuSublevel) {
    }

    @Override
    public String printSubLevel2(MenuSublevel menuLevel) {
        return "----" + menuLevel.addSubLevel(menuLevel) + count++ + ".";    }
}
