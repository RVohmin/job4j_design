package ru.job4j.design.isp;

/**
 * @author RVohmin
 * @since 19.03.2020
 */
public class Menu {
    public static void main(String[] args) {

        MenuLevel menuTask = new MenuLevel("Task", 1);
        MenuSublevel menuSublevel = new MenuSublevel(menuTask);
        MenuSubLevel2 menuSubLevel2 = new MenuSubLevel2(menuSublevel);

        String menu = System.lineSeparator()
                + menuTask.printlevel()
                + menuSublevel.addSubLevel(menuTask)
                + System.lineSeparator()
                + menuSublevel.addSubLevel(menuTask)
                + System.lineSeparator()
                + menuSublevel.addSubLevel(menuTask)
                + System.lineSeparator()
                + menuSubLevel2.printSubLevel2(menuSublevel);
        System.out.println(menu);
    }
}
