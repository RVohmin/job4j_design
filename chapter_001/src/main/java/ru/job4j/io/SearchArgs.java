package ru.job4j.io;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ru.job4j.io.SearchArgs
 *
 * @author romanvohmin
 * @version 1
 * @since 26.03.2020
 */
public class SearchArgs {
    private String[] args;
    List<String> listExt = new ArrayList<>();

    public SearchArgs(String[] args) {
        this.args = args;
    }

    public Path checkDirectory() throws Exception {
        File dirStart = new File(args[1]);
        Path start;
        if (dirStart.isDirectory() && dirStart.exists()) {
            start = Paths.get(args[1]);
        } else {
            throw new Exception("Entered Path is not exist or not directory");
        }
        return start;
    }

    public List<String> checkExt() {
        listExt.addAll(Arrays.asList(args).subList(3, args.length));
        return listExt;
    }
}
