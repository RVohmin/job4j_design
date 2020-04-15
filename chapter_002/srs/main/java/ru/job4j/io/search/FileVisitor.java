package ru.job4j.io.search;

import java.io.File;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.nio.file.FileVisitResult.CONTINUE;

/**
 * ru.job4j.io.search.FileVisitor
 *
 * @author romanvohmin
 * @version 1
 * @since 01.04.2020
 */
public class FileVisitor extends SimpleFileVisitor<Path> {

    private CheckName checkName;
    private List<File> listPaths = new ArrayList<>();

    public FileVisitor(CheckName checkName) {
        this.checkName = checkName;
    }

    public List<File> getListPaths() {
        return listPaths;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        try {
            if (checkName.checkExt(file)) {
                listPaths.add(new File(file.toString()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CONTINUE;
    }
}

