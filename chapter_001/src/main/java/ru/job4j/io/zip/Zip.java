package ru.job4j.io.zip;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
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
public class Zip extends SimpleFileVisitor<Path> {
    private Args helper;
    private List<String> listExcludes = helper.getExcludes();
    List<File> listPaths;

    public Zip(Args helper) {
        this.helper = helper;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        for (String ext : listExcludes) {
            if (!file.toAbsolutePath().getFileName().toString().endsWith(ext)) {
                File f = new File(file.toAbsolutePath().toString());
                listPaths.add(f);
            }
        }
        return CONTINUE;
    }

    public List<File> seekBy(String path) throws IOException {
        Files.walkFileTree(Paths.get(path), this);
        return listPaths;
    }

    public void pack(List<File> source, File target) {
        for (File file : listPaths) {
//            File f = new File(path);
            try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
                zip.putNextEntry(new ZipEntry(file.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file))) {
                    zip.write(out.readAllBytes());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            throw new IllegalStateException("arg must as example: java -jar pack.jar -d c:\\project\\job4j\\ -e *.java -o project.zip");
        }
        for (String item : args) {
            System.out.println("argument: " + item);
        }
        Args arguments = new Args(args);
        Zip zip = new Zip(arguments);
        zip.pack(zip.seekBy(arguments.directory()), arguments.output());

//        System.out.println(Arrays.toString(args1.arguments));
//        zip.seekBy("/Users/romanvohmin/projects/job4j_design/chapter_001/src/main/java/ru/job4j/io/zip");
//        zip.getList().forEach(System.out::println);
//        new Zip("java").pack(new File("./chapter_001/"), new File("./chapter_001/chapter_001.zip"));
    }
}
