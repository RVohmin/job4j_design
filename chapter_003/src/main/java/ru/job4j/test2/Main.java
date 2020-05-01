package ru.job4j.test2;

import java.util.Scanner;

/**
 * job4j_design ru.job4j.test2.Main
 *
 * @author romanvohmin
 * @since 01.05.2020 19:36
 */
public class Main {

    public static void main(String[] args) {
        Storage storage = new Storage();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите действие:)");
        System.out.println("1 - создать нового пользователя;");
        System.out.println("2 - добавить email к существующему пользователю;");
        System.out.println("3 - вывести список пользователей и email");
        System.out.println("4 - вывести список объединенных пользователей и email");
        System.out.println("Enter - выход");
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    System.out.println("Введите имя пользователя");
                    String name = scanner.nextLine();
                    User user = new User(name);
                    storage.addUser(user);
                    break;
                case "2":
                    System.out.println("Введите имя пользователя, к которому добавить email");
                    name = scanner.nextLine();
                    System.out.println("Введите email");
                    String email = scanner.nextLine();
                    user = storage.getUser(name);
                    user.setEmail(email);
                    storage.mergeUsers(user);
                    break;
                case "3":
                    for (User item : storage.getUsers()) {
                        System.out.println(item.getName() + "\t" + item.getEmails());
                    }
                    break;
                case "4":
                    for (User item : storage.getMergeUsers()) {
                        System.out.println(item.getName() + "\t" + item.getEmails());
                    }
                    break;
                case "":
                    return;
                default:
                    System.out.println("Неверная команда.");
                    break;
            }
        }

    }


}
