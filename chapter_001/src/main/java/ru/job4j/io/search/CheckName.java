package ru.job4j.io.search;

import java.nio.file.Path;

/**
 * ru.job4j.io.search.CheckName
 *
 * @author romanvohmin
 * @since 03.04.2020
 */
public class CheckName {
    private ArgCheck args;

    public CheckName(ArgCheck args) {
        this.args = args;
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

    public boolean checkExt(Path file) throws Exception {
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
}
