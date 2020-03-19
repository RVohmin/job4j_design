package ru.job4j.io;

import java.io.FileOutputStream;

/**
 * @author RVohmin
 * @since 19.03.2020
 */
public class TableToFile {
    static int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                table[i][j] = (j + 1) * (i + 1);
                System.out.print("\t");
                System.out.print(table[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }
        return table;
    }

    static int[][] multipleToFile(int size) {
        int[][] table = new int[size][size];
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table.length; j++) {
                    table[i][j] = (j + 1) * (i + 1);
                    out.write("\t".getBytes());
                    out.write(Integer.toString(table[i][j]).getBytes());
                    out.write("\t".getBytes());
                }
                out.write("\n".getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return table;
    }

    public static void main(String[] args) {
        multipleToFile(5);
    }
}
