package ru.job4j.io;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

/**
 * ru.job4j.io.Abuse
 *
 * @author romanvohmin
 * @version 1
 * @since 22.03.2020
 */
public class Abuse {
    public static void drop(String source, String target, List<String> words) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            in.lines()
                    .flatMap(line -> Stream.of(line.split("\\s+")))
                    .filter(word -> !words.contains(word)).map(word -> word + " ")
                    .forEach(out::print);
        }
    }
}
