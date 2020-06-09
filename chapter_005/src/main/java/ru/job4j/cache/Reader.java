package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

    public String getTextfromFile(String fileName) {
        StringBuilder text = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            in.lines().forEach(str -> text.append(str).append(System.lineSeparator()));
        } catch (IOException f) {
            f.printStackTrace();
        }
        return text.toString();
    }
}
