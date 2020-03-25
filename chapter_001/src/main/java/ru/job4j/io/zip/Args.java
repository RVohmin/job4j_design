package ru.job4j.io.zip;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * ru.job4j.io.zip.Args
 *
 * @author romanvohmin
 * @version 1
 * @since 24.03.2020
 */
public class Args {
    String[] arguments;
    File dir = null;
    List<String> excludes = new ArrayList<>();
    List<String> allPaths = new ArrayList<>();
    List<String> output = new ArrayList<>();

    public List<String> getExcludes() {
        return excludes;
    }

    public Args(String[] arguments) {
        this.arguments = arguments;
    }

    /**
     * проверка на существование полученного пути и занесение всех подпутей в лист
     *
     * @throws Exception
     */
    public String directory() throws Exception {
        dir = new File(arguments[1]);
        if (!dir.isDirectory() || !dir.exists()) {
            throw new Exception("input path is not Directory or not exist");
        }
//        allPaths.addAll(Arrays.asList(Objects.requireNonNull(dir.list())));
        return dir.toString();
    }

    /**
     * проверка формата полученных аргументов на корректность *.ext и занесение их в лист
     *
     * @throws Exception
     */
    public List<String> exclude() throws Exception {
        for (int i = 3; i < arguments.length; i++) {
            while (arguments[i].equals("-o")) {
                if (!arguments[i].toLowerCase().startsWith("*.")) {
                    throw new Exception("Extension must starts with *.");
                }
            }
        }
        Arrays.stream(arguments)
                .filter(x -> x.startsWith("*."))
                .map(x -> x.substring(2))
                .forEach(x -> excludes.add(x));
        return excludes;
    }

    /**
     * Проверка на окончание .zip и получение списка файлов для архивации с учетом структуры каталогов
     *
     * @throws Exception
     */
    public File output() throws Exception {
        String outputName = "";
        Arrays.stream(arguments).dropWhile(x -> x.equals("-o")).findFirst().ifPresent(x -> x = outputName);
        if (!outputName.toLowerCase().endsWith(".zip")) {
            throw new Exception("Неверное расширение, должно быть .zip");
        }
//        for (String path : allPaths) {
//            for (String ext : excludes) {
//                if (!path.endsWith(ext)) {
//                    output.add(path);
//                }
//            }
//        }
        return new File(outputName);
    }
}
