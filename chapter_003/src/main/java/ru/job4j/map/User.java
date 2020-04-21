package ru.job4j.map;

import java.util.Calendar;
import java.util.Objects;
import java.util.UUID;

/**
 * job4j_design ru.job4j.map.User
 *
 * @author romanvohmin
 * @since 21.04.2020 12:32
 */
public class User {
    String name;
    int children;
    Calendar birthday;

    public User() {
        this.name = UUID.randomUUID().toString();
        this.children = (int) (Math.random() * 10);
    }

    public User(String name, int children) {
        this.name = name;
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return children == user.children &&
                Objects.equals(name, user.name) &&
                Objects.equals(birthday, user.birthday);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", children=" + children +
                ", birthday=" + birthday +
                '}';
    }
}
