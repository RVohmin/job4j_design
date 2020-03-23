package ru.job4j.io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.FileVisitResult.CONTINUE;

/**
 * ru.job4j.io.Search
 *
 * @author romanvohmin
 * @version 1
 * @since 22.03.2020
 */
public class Search {

    public static void main(String[] args) throws IOException {
        Path start = Paths.get("../");
        Search.search(start, "java").forEach(System.out::println);
    }

    public static List<String> search(Path root, String ext) throws IOException {
        PrintFiles printFiles = new PrintFiles();
        printFiles.ext = ext;
        Files.walkFileTree(root, printFiles);
        return printFiles.getList();
    }
}
