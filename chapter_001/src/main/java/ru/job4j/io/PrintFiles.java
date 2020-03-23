package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.FileVisitResult.CONTINUE;

/**
 * ru.job4j.io.PrintFiles
 *
 * @author romanvohmin
 * @version 1
 * @since 22.03.2020
 */
public class PrintFiles implements FileVisitor<Path> {
    String ext;
    List<String> list = new ArrayList<>();

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        return CONTINUE;
    }

    public String getExt() {
        return ext;
    }

    public List<String> getList() {
        return list;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (file.toAbsolutePath().getFileName().toString().endsWith(getExt())) {
            list.add(file.toAbsolutePath().getFileName().toString());
        }
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        return CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
        return CONTINUE;
    }
}
