package ru.job4j.test2;

import java.util.ArrayList;
import java.util.List;

/**
 * job4j_design ru.job4j.test2.User
 *
 * @author romanvohmin
 * @since 01.05.2020 11:15
 */
public class User {
    private final String name;
    private List<String> emails = new ArrayList<>();


    public User(String name) {
        this.name = name;
    }

    public User(String name, List<String> emails) {
        this.name = name;
        this.emails = emails;
    }

    public List<String> getEmails() {
        return emails;
    }

    public boolean setEmail(String email) {
        return emails.add(email);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", emails=" + emails +
                '}';
    }
}
