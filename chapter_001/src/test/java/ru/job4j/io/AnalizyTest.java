package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringJoiner;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class AnalizyTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenFilterFrom400Or500To200Or300() throws IOException {
        Analizy o = new Analizy();
        File source = folder.newFile("..//!server.logos");
        File target = folder.newFile("..//!server.logos");
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (Stream<String> streamFromFiles = Files.lines(Paths.get("..//unavailable.csv"))) {
            streamFromFiles.forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }

        o.unavailable("..//!server.logos", "..//!server.logos");
        String expected = "10:58:01-10:59:01\n"
                + "11:01:02-11:02:02\n"
                + "12:00:01-13:01:01\n"
                + "14:01:02-14:02:02";
        String result = out.toString();
        assertEquals(expected, result);
    }

}