package ru.job4j.io.search;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * ru.job4j.io.search.search
 *
 * @author romanvohmin
 * @version 1
 * @since 01.04.2020
 */
public class SearchFile {
    private final FileVisitor fileVisitor;

    public SearchFile(CheckName checkName) {
        this.fileVisitor = new FileVisitor(checkName);
    }

    public void seekBy(String root) throws Exception {
        Files.walkFileTree(Paths.get(root), fileVisitor);
        List<File> listFiles = fileVisitor.getListPaths();
        write(listFiles);
    }

    private void write(List<File> listFiles) {
        File output = new File("searchResult.txt");
        try {
            if (!output.createNewFile()) {
                output.delete();
                output.createNewFile();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        for (File item : listFiles) {
            try (BufferedWriter out = new BufferedWriter(new FileWriter(output, true))) {
                out.write(item.toString() + System.lineSeparator());
            } catch (Exception e) {
                e.getStackTrace();
            }

        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            throw new IllegalStateException("arg must as example: java -jar find.jar -d c:/ -n *.txt -m -o log.txt, "
                    + "where -m - finding by mack; либо -f - full name match; -r regular expression.");
        }
        ArgCheck arguments = new ArgCheck(args);
        CheckName checkName = new CheckName(arguments);
        SearchFile searchFile = new SearchFile(checkName);
        searchFile.seekBy(arguments.getDir());
        searchFile.fileVisitor.getListPaths().forEach(System.out::println);
    }
}
