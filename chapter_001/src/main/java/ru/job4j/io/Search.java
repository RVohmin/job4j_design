package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

/**
 * ru.job4j.io.Search
 *
 * @author romanvohmin
 * @version 1
 * @since 22.03.2020
 */
public class Search {
SearchArgs searchArgs;

    public Search(SearchArgs searchArgs) {
        this.searchArgs = searchArgs;
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            throw new IllegalStateException("No arguments. Usage example: java Class -d /Users/romanvohmin/projects/job4j_design -ext xml");
        }
        SearchArgs searchArgs = new SearchArgs(args);
        Search search = new Search(searchArgs);
        for (String ext : searchArgs.checkExt()) {
            Search.search(searchArgs.checkDirectory(), ext).forEach(System.out::println);
        }
    }

    public static List<String> search(Path root, String ext) throws IOException {
        PrintFiles printFiles = new PrintFiles(ext);
        Files.walkFileTree(root, printFiles);
        return printFiles.getList();
    }
}
