package ru.job4j.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * ru.job4j.io.Analizy
 *
 * @author romanvohmin
 * @version 1
 * @since 20.03.2020
 */
public class Analizy {
    public void unavailable(String source, String target) {
        String temp;
        String line;

        try (BufferedReader fr = new BufferedReader(new FileReader(source));
             BufferedWriter fw = new BufferedWriter(new FileWriter(target))) {
            while ((line = fr.readLine()) != null) {
                if (line.startsWith("400") || line.startsWith("500")) {
                    temp = line.substring(4) + "-";
                    line = fr.readLine();
                    while (line != null) {
                        if ((line.startsWith("200") || line.startsWith("300"))) {
                            fw.write(temp + line.substring(4) + "\n");
                            break;
                        }
                        line = fr.readLine();
                    }
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy o = new Analizy();
        o.unavailable("!server.logos", "unavailable.csv");
    }
}
