package ru.job4j.io;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * @author RVohmin
 * @since 19.03.2020
 */
public class EvenNumberFile {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(new FileInputStream("even.txt"))) {
            while (scanner.hasNext()) {
                int read = scanner.nextInt();
                if (read % 2 != 0) {
                    System.out.println("Число " + read + " нечетное");
                }
            }
        }
    }
}
