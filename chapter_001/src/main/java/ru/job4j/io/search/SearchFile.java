package ru.job4j.io.search;

import ru.job4j.io.Search;

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
    ArgCheck arguments;
    FileVisitor fileVisitor;
    List<File> listFiles;
    File output;

    public SearchFile(ArgCheck arguments) {
        this.arguments = arguments;
        this.fileVisitor = new FileVisitor(arguments);
        this.output = new File("searchResult.txt");
    }

    public List<File> seekBy(String root) throws Exception {
        Files.walkFileTree(Paths.get(root), fileVisitor);
        listFiles = fileVisitor.getListPaths();
        write(listFiles);
        return listFiles;
    }

    private void write(List<File> listFiles) {
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
            throw new IllegalStateException("arg must as example: java -jar find.jar -d c:/ -n *.txt -m -o log.txt, " +
                    "where -m - finding by mack; либо -f - full name match; -r regular expression.");
        }
        ArgCheck arguments = new ArgCheck(args);
        SearchFile searchFile = new SearchFile(arguments);
        searchFile.seekBy(arguments.directory());
        searchFile.fileVisitor.getListPaths().forEach(System.out::println);
    }
}
