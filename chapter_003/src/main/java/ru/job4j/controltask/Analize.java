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
        info.added = (int) current.stream().dropWhile(previous::contains).count();
        info.deleted = (int) previous.stream().filter(o -> !current.contains(o)).count();
        info.changed = (int) previous.stream().
                filter(current::contains).
                filter(o -> !o.getName().equals(current.get(current.indexOf(o)).getName())).
                count();
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
