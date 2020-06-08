package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

    public String getTextfromFile(String fileName) {
        String srcRoot = "/Users/romanvohmin/projects/job4j_design/chapter_005/src/main/java/ru/job4j/cache/";
        File file = new File(fileName);
        StringBuilder text = new StringBuilder();

        try (BufferedReader in = new BufferedReader(new FileReader(srcRoot + fileName))) {
//            assert false;
            in.lines().forEach(str -> text.append(str).append("\n"));
        } catch (IOException f) {
            f.printStackTrace();
        }
        return text.toString();
    }
}
