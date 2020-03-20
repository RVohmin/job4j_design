package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ru.job4j.io.Analizy
 *
 * @author romanvohmin
 * @version 1
 * @since 20.03.2020
 */
public class Analizy {
    public void unavailable(String source, String target) {
        StringBuilder str = new StringBuilder();
        List<String> list = new ArrayList<>();
        List<String> list3 = new ArrayList<>();

        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            list = read.lines()
                    .filter(x -> (!x.startsWith("//")
                            && !x.startsWith("/*")
                            && !x.startsWith("*")
                            && x.length() != 0))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> list2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).startsWith("400") || list.get(i).startsWith("500")) {
                list2.add(list.get(i).substring(4) + "-");
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
                    list2.add(list.get(i).substring(4));
                    list2.add(System.lineSeparator());
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
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("!!!   15:01:30;15:02:32");
            out.println("!!!   15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Analizy o = new Analizy();
        o.unavailable("server.log", "unavailable.csv");
    }
}
