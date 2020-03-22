package ru.job4j.io;

import java.io.File;

/**
 * ru.job4j.io.Dir
 *
 * @author romanvohmin
 * @version 1
 * @since 22.03.2020
 */
public class Dir {
    public static void main(String[] args) {
        File file = new File("../");
        if (!file.exists()) {
            throw new IllegalStateException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalStateException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        System.out.println(String.format("size : %s", file.getTotalSpace()));
        for (File subfile : file.listFiles()) {
            System.out.println(subfile.getAbsoluteFile().getName() + " size = " + subfile.getAbsoluteFile().length());
        }
    }
}
