package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author RVohmin
 * @since 20.03.2020
 */
public class LogFilter {
    public static List<String> filter(String file) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader("log.txt"))) {
            in.lines().forEach(lines::add);
            lines = lines.stream()
                    .filter(x -> x.contains("404"))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.getStackTrace();
        }
        return lines;
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            filter(file).forEach(x -> {
                out.write(x);
                out.write(System.lineSeparator());
            });
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
        save(log, "404.txt");
    }
}
