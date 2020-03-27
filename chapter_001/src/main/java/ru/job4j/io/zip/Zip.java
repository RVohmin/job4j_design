package ru.job4j.io.zip;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static java.nio.file.FileVisitResult.CONTINUE;

/**
 * ru.job4j.io.zip.Zip
 *
 * @author romanvohmin
 * @version 1
 * @since 24.03.2020
 */
public class Zip {
    private Args helper;
    private FileVisitor fileVisitor;

    public Zip(Args helper) {
        this.helper = helper;
        this.fileVisitor = new FileVisitor(helper.getExcludes());
    }

    public List<File> seekBy(String root) throws Exception {
        helper.exclude();
        Files.walkFileTree(Paths.get(root), fileVisitor);
        return fileVisitor.getListPaths();
    }

    public void pack(List<File> listPaths, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File file : listPaths) {
                zip.putNextEntry(new ZipEntry(file.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            throw new IllegalStateException("arg must as example: java -jar pack.jar -d c:\\project\\job4j\\ -e *.java -o project.zip");
        }
        Args arguments = new Args(args);
        Zip zip = new Zip(arguments);
        zip.pack(zip.seekBy(arguments.directory()), arguments.output());
    }
}
