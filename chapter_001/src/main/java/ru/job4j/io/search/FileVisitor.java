package ru.job4j.io.search;

import java.io.File;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
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

    ArgCheck args;
    List<File> listPaths = new ArrayList<>();

    public FileVisitor(ArgCheck argCheck) {
        this.args = argCheck;
    }

    public List<File> getListPaths() {
        return listPaths;
    }

    private String maskToRegExp(String mask) {
        char[] charArr = mask.toCharArray();
        StringBuilder regExp = new StringBuilder();
        for (char item : charArr) {
            if (item == '*') {
                String temp = ".+?";
                regExp.append(temp);
                continue;
            }
            regExp.append(item);
        }
        return regExp.toString();
    }

    private boolean checkExt(Path file) throws Exception {
        boolean check = true;
        String template = args.fileName();
        switch (args.getArguments()[4]) {
            case "-m":
                String regExp = maskToRegExp(template);
                check = file.getFileName().toString().matches(regExp);
                break;
            case "-r":
            case "-f":
                check = file.getFileName().toString().matches(template);
                break;
        }
        return check;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        try {
            if (checkExt(file)) {
                listPaths.add(new File(file.toString()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CONTINUE;
    }
}

