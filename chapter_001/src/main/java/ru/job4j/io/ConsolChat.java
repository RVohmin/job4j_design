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
    private final File textGuess;
    private static final String END = "закончить";
    private static final String CONTINUE = "продолжить";
    private static final String STOP = "стоп";


    public ConsolChat(File textGuess) {
        this.textGuess = textGuess;
    }

    public void chat() {
        Map<Integer, String> textMap = new HashMap<>();
        File logChat = new File("logChat.txt");
        int count = 1;
        boolean checkAnswer = true;
        String line;
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
            while (!word.equalsIgnoreCase(END)) {
                word = scanner.nextLine();
                fw.write(word + "\n");
                if (!word.equalsIgnoreCase(STOP)
                        && !word.equalsIgnoreCase(END)
                        && checkAnswer
                        || word.equalsIgnoreCase(CONTINUE)) {
                    int numAnswer = (int) (Math.random() * count);
                    String phrase = textMap.get(numAnswer);
                    System.out.println(phrase);
                    fw.write(phrase + "\n");
                } else {
                    checkAnswer = false;
                }
                if (word.equalsIgnoreCase(CONTINUE)) {
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