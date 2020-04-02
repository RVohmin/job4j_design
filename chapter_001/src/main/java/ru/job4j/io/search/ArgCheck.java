package ru.job4j.io.search;

import java.io.File;

/**
 * ru.job4j.io.search.ArgCheck
 *
 * @author romanvohmin
 * @version 1
 * @since 01.04.2020
 */
public class ArgCheck {
    private String[] arguments;
    private String dir;

    public ArgCheck(String[] args) {
        this.arguments = args;
    }

    public String[] getArguments() {
        return arguments;
    }

    public String getDir() throws Exception {
        dir = this.directory();
        return dir;
    }

    public String directory() throws Exception {
        if (!arguments[0].equals("-d")) {
            throw new Exception("First argument must -d");
        }
        File dir = new File(arguments[1]);
        if (!dir.isDirectory() || !dir.exists()) {
            throw new Exception("input path is not Directory or not exist");
        }
        return dir.toString();
    }

    public String fileName() throws Exception {
        if (!arguments[2].equals("-n")) {
            throw new Exception("incorrect arguments, must as example: java -jar find.jar -d c:/ -n *.txt -m -o log.txt");
        }
        return arguments[3];
    }
}
