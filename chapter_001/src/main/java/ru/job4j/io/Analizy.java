package ru.job4j.io;

import java.io.*;
import java.util.Scanner;

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
        try (FileReader fr = new FileReader(source);
             FileWriter fw = new FileWriter(target);
             Scanner scan = new Scanner(fr)) {
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                if (line.startsWith("400") || line.startsWith("500")) {
                    temp = line.substring(4) + "-";
                    line = scan.nextLine();
                    while (line != null) {
                        if ((line.startsWith("200") || line.startsWith("300"))) {
                            fw.write(temp + line.substring(4) + "\n");
                            break;
                        }
                        line = scan.nextLine();
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
