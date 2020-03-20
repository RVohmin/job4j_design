package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ru.job4j.io.Analizy
 *
 * @author romanvohmin
 * @version 1
 * @since 20.03.2020
 */
public class Analizy {
    public void unavailable(String source, String target) {
        List<String> list = new ArrayList<>();
        try (Stream<String> streamFromFiles = Files.lines(Paths.get(source))) {
            list = streamFromFiles
                    .filter(x -> (!x.startsWith("//")
                            && !x.startsWith("/*")
                            && !x.startsWith("*")
                            && x.length() != 0))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> list2 = new ArrayList<>();
        String temp;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).startsWith("400") || list.get(i).startsWith("500")) {
                temp = list.get(i).substring(4) + "-";
            } else {
                continue;
            }
            i++;
            while (!list.get(i).startsWith("400") || !list.get(i).startsWith("500")) {
                if (list.get(i).startsWith("400") || list.get(i).startsWith("500")) {
                    i++;
                    continue;
                }
                if (!list.get(i).startsWith("400") || !list.get(i).startsWith("500")) {
                    list2.add(temp + list.get(i).substring(4));
                    break;
                }
                i++;
            }
        }

        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            for (String item : list2) {
                out.println(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy o = new Analizy();
        o.unavailable("!server.logos", "unavailable.csv");
    }
}
