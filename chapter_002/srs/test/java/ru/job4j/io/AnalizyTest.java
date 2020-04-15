package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import java.io.*;
import java.util.Scanner;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizyTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenFilterFrom400Or500To200Or300() throws IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        try (FileReader fr = new FileReader("..//!server.logos");
             FileWriter fw = new FileWriter(source.getAbsolutePath());
             Scanner scan = new Scanner(fr)) {
            String line;
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                fw.write(line);
                fw.write(System.lineSeparator());
            }
        }

        Analizy obj = new Analizy();
        obj.unavailable(source.getAbsolutePath(), target.getAbsolutePath());

        StringJoiner res = new StringJoiner(System.lineSeparator());
        try (BufferedReader in = new BufferedReader(new FileReader(target.getAbsolutePath()))) {
            in.lines().forEach(res::add);
        }
        String expected = "10:58:01-10:59:01\n"
                + "11:01:02-11:02:02\n"
                + "12:00:01-13:01:01\n"
                + "14:01:02-14:02:02";
        assertThat(res.toString(), is(expected));
    }

}