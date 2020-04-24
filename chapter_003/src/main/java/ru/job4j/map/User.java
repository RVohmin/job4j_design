package ru.job4j.map;

import java.util.UUID;

/**
 * job4j_design ru.job4j.map.User
 *
 * @author romanvohmin
 * @since 21.04.2020 12:32
 */
public final class User {
    private final String name;
    private final int children;
//    private Calendar birthday;

    public String getName() {
        return name;
    }

    public int getChildren() {
        return children;
    }

    public User() {
        this.name = UUID.randomUUID().toString();
        this.children = (int) (Math.random() * 10);
    }

    public User(String name, int children) {
        this.name = name;
        this.children = children;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", children=" + children +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getChildren() != user.getChildren()) return false;
        return getName() != null ? getName().equals(user.getName()) : user.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getChildren();
        return result;
    }

    public static void main(String[] args) {

    }
}
