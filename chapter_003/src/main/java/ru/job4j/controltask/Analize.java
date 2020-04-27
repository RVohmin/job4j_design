package ru.job4j.controltask;

import java.util.List;

/**
 * job4j_design ru.job4j.controltask.Analize
 *
 * @author romanvohmin
 * @since 27.04.2020 00:04
 */
public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        for (User item : current) {
            if (!previous.contains(item)) {
                info.added++;
            }
        }
        for (User item : previous) {
            if (current.contains(item) && item.getName().equals(current.get(current.indexOf(item)).getName())) {
                info.deleted++;
            }
        }
        for (User item : previous) {
            if (current.contains(item) && !item.getName().equals(current.get(current.indexOf(item)).getName())) {
                info.changed++;
            }
        }
        return info;
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof User)) return false;

            User user = (User) o;

            return getId() == user.getId();
        }

        @Override
        public int hashCode() {
            return getId();
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;
    }
}
