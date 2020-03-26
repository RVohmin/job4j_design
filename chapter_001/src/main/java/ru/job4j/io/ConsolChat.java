package ru.job4j.io;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;

/**
 * ru.job4j.io.consolChat
 *
 * @author romanvohmin
 * @version 1
 * @since 23.03.2020
 */
public class ConsolChat {
    File logChat = new File("logChat.txt");
    private final File textGuess;
    Map<Integer, String> textMap = new HashMap<>();
    String line;
    boolean checkAnswer = true;

    public ConsolChat(File textGuess) {
        this.textGuess = textGuess;
    }

    public void chat() {
        int count = 1;
        try (BufferedReader fr = new BufferedReader(new FileReader(textGuess))) {
            while ((line = fr.readLine()) != null) {
                textMap.put(count, line);
                fr.readLine();
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String word = "";
        try (BufferedWriter fw = new BufferedWriter(new FileWriter(logChat));
             Scanner scanner = new Scanner(System.in)) {
            while (!word.equals("закончить")) {
                word = scanner.nextLine();
                fw.write(word + "\n");
                if (!word.toLowerCase().equals("стоп")
                        && !word.toLowerCase().equals("закончить")
                        && checkAnswer
                        || word.toLowerCase().equals("продолжить")) {
                    int numAnswer = (int) (Math.random() * count);
                    String phrase = textMap.get(numAnswer);
                    System.out.println(phrase);
                    fw.write(phrase + "\n");
                } else {
                    checkAnswer = false;
                }
                if (word.toLowerCase().equals("продолжить")) {
                    checkAnswer = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsolChat chat = new ConsolChat(new File("./text.txt"));
        chat.chat();
    }
}