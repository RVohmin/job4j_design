package ru.job4j.io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * ru.job4j.io.consolChat
 *
 * @author romanvohmin
 * @version 1
 * @since 23.03.2020
 */
public class ConsolChat {
    private final File textGuess;
    private final File logChat;
    private static final String END = "закончить";
    private static final String CONTINUE = "продолжить";
    private static final String STOP = "стоп";
    private final Map<Integer, String> textMap = new HashMap<>();
    private int count = 1;

    /**
     * constructor
     * @param textGuess - file with answers
     */
    public ConsolChat(File textGuess) {
        this.textGuess = textGuess;
        this.logChat = new File("logChat.txt");
    }

    /**
     * Reading File with answers to temporary List
     */
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

    /**
     * writing user input & random phrase to log
     * @param word String that input user
     */
    private void writeLogChat(String word) {
        try (BufferedWriter fw = new BufferedWriter(new FileWriter(this.logChat, true))) {
            fw.write(word + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * this method asked user for input from console and
     * print random phrase as answer
     */
    public void readConsole() {
        this.readFileAnswers();
        boolean checkAnswer = true;
        String word = "";
        try (Scanner scanner = new Scanner(System.in)) {
            while (!END.equalsIgnoreCase(word)) {
                word = scanner.nextLine();
                writeLogChat(word);
                if (!STOP.equalsIgnoreCase(word)
                        && !END.equalsIgnoreCase(word)
                        && checkAnswer
                        || CONTINUE.equalsIgnoreCase(word)) {
                    int numAnswer = (int) (Math.random() * count);
                    String phrase = textMap.get(numAnswer);
                    System.out.println(phrase);
                    writeLogChat(phrase);
                } else {
                    checkAnswer = false;
                }
                if (CONTINUE.equalsIgnoreCase(word)) {
                    checkAnswer = true;
                }
            }
        }
    }

    /**
     * main method calls chat
     * @param args - no args
     */
    public static void main(String[] args) {
        ConsolChat chat = new ConsolChat(new File("./text.txt"));
        chat.readConsole();
    }
}
