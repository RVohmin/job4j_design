package ru.job4j.io.task;

import java.io.IOException;

/**
 * ru.job4j.io.task.Directory
 *
 * @author romanvohmin
 * @version 1
 * @since 01.04.2020
 */
public class Directory {

    public static void main(String[] args) {

        final Shell shell = new Shell();
        assert shell.path().equals("/");

        shell.cd("/");
        assert shell.path().equals("/");

        shell.cd("usr/..");
        assert shell.path().equals("/");

        shell.cd("usr").cd("local");
        shell.cd("../local").cd("./");
        assert shell.path().equals("/usr/local");

        shell.cd("..");
        assert shell.path().equals("/usr");

        shell.cd("//lib///");
        assert shell.path().equals("/lib");
    }
}
