package ru.job4j.io;

import java.io.*;
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
    private File logChat;
    private static final String END = "закончить";
    private static final String CONTINUE = "продолжить";
    private static final String STOP = "стоп";
    private Map<Integer, String> textMap = new HashMap<>();
    private int count = 1;


    public ConsolChat(File textGuess) {
        this.textGuess = textGuess;
        this.logChat = new File("logChat.txt");
    }

    private void readFileAnswers() {
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
    }

    private void chat(String word) {
        try (BufferedWriter fw = new BufferedWriter(new FileWriter(this.logChat, true))) {
            fw.write(word + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readConsole() {
        this.readFileAnswers();
        boolean checkAnswer = true;
        String word = "";
        try (Scanner scanner = new Scanner(System.in)) {
            while (!END.equalsIgnoreCase(word)) {
                word = scanner.nextLine();
                chat(word);
                if (!STOP.equalsIgnoreCase(word)
                        && !END.equalsIgnoreCase(word)
                        && checkAnswer
                        || CONTINUE.equalsIgnoreCase(word)) {
                    int numAnswer = (int) (Math.random() * count);
                    String phrase = textMap.get(numAnswer);
                    System.out.println(phrase);
                    chat(phrase);
                } else {
                    checkAnswer = false;
                }
                if (CONTINUE.equalsIgnoreCase(word)) {
                    checkAnswer = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        ConsolChat chat = new ConsolChat(new File("./text.txt"));
        chat.readConsole();
    }
}