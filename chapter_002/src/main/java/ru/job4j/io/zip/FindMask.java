package ru.job4j.io.zip;

/**
 * ru.job4j.io.zip.FindMask
 *
 * @author romanvohmin
 * @version 1
 * @since 01.04.2020
 */
public class FindMask implements FindAble {

    @Override
    public String getFileMask(String arg) {
        return arg.substring(2);
    }
}
