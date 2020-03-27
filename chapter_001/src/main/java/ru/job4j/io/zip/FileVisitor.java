package ru.job4j.io.zip;

import java.io.File;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.FileVisitResult.CONTINUE;

/**
 * ru.job4j.io.zip.FileVisitor
 *
 * @author romanvohmin
 * @version 1
 * @since 27.03.2020
 */
public class FileVisitor extends SimpleFileVisitor<Path> {
    List<File> listPaths = new ArrayList<>();
    List<String> extensions;

    public FileVisitor(List<String> extensions) {
        this.extensions = extensions;
    }

    public List<File> getListPaths() {
        return listPaths;
    }

    private boolean checkExt(Path file) {
        boolean check = true;
        for (String ext : extensions) {
            if (file.toString().contains(".git") || file.toString().contains("target") || file.toString().contains(ext)) {
                check = false;
            }
        }
        return check;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (checkExt(file)) {
            listPaths.add(new File(file.toString()));
        }
        return CONTINUE;
    }
}
