package ru.job4j.controltask;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * job4j_design ru.job4j.controltask.Analize
 *
 * @author romanvohmin
 * @since 27.04.2020 00:04
 */
public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        Map<Integer, User> prevMap = new HashMap<>();
        Map<Integer, User> currentMap = new HashMap<>();
        for (User item : previous) {
            prevMap.put(item.id, item);
        }
        for (User item : current) {
            currentMap.put(item.id, item);
        }
        for (Map.Entry<Integer, User> item : prevMap.entrySet()) {
            int key = item.getKey();
            User value = item.getValue();
            if (currentMap.containsKey(key)) {
                info.deleted++;
            }
            if (currentMap.containsKey(key) && !value.getName().equals(currentMap.get(key).getName())) {
                info.changed++;
            }
        }
        for (User item : current) {
            if (!prevMap.containsKey(item.getId())) {
                info.added++;
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
