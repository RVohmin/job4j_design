package ru.job4j.io;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringJoiner;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class AnalizyTest {
    @Test
    public void whenFilterFrom400Or500To200Or300() {
        Analizy o = new Analizy();
        o.unavailable("..//server.log", "unavailable.csv");
        String expected = "10:58:01-10:59:01\n"
                + "11:01:02-11:02:02\n"
                + "12:00:01-13:00:01\n"
                + "14:01:02-14:02:02";
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (Stream<String> streamFromFiles = Files.lines(Paths.get("..//unavailable.csv"))) {
            streamFromFiles.forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String result = out.toString();
        assertEquals(expected, result);
    }

}