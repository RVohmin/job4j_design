package ru.job4j.test2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * job4j_design ru.job4j.test2.Storage
 *
 * @author romanvohmin
 * @since 01.05.2020 11:48
 */
public class Storage {
    private final Map<String, List<String>> map = new HashMap<>();
    private final List<User> users = new ArrayList<>();
    private final List<User> mergeUsers = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public User getUser(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getMergeUsers() {
        fillMergedList();
        return mergeUsers;
    }

    public void addUser(User user) {
        users.add(user);
        if (user.getEmails().size() != 0) {
            mergeUsers(user);
        }
    }

//    private void fillMap() {
//        for (User item : users) {
//            mergeUsers(item);
//        }
//    }

    public void mergeUsers(User user) {
        boolean flag = false;
        List<String> tempUserList = new ArrayList<>(user.getEmails());
        if (map.size() == 0) {
            map.put(user.getName(), new ArrayList<>(user.getEmails()));
        } else {
            for (Map.Entry<String, List<String>> item : map.entrySet()) {
                List<String> tempMapList = new ArrayList<>(item.getValue());
                if (tempUserList.removeAll(tempMapList)) {
                    item.getValue().addAll(tempUserList);
                    System.out.println("!!!" + map);
                    flag = true;
                }
            }
            if (map.size() > 1 && map.containsKey(user.getName()) && flag) {
                map.remove(user.getName());
            }
            if (!flag && user.getEmails().size() != 0) {
                map.put(user.getName(), user.getEmails());
            }
        }
    }

    private void fillMergedList() {
        mergeUsers.clear();
//        fillMap();
        for (Map.Entry<String, List<String>> item : map.entrySet()) {
            mergeUsers.add(new User(item.getKey(), item.getValue()));
        }
    }
}
