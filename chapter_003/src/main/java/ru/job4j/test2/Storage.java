package ru.job4j.test2;

import java.util.*;

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
    }

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

    public List<User> newMergeUsers(List<User> users) {
        Queue<User> queueUsers = new LinkedList<>(users);
        while (!queueUsers.isEmpty()) {
            boolean flag = false;
            User user = queueUsers.poll();
            List<String> tempUserList = new ArrayList<>(user.getEmails());
            if (map.size() == 0) {
                map.put(user.getName(), new ArrayList<>(user.getEmails()));
            } else {
                for (Map.Entry<String, List<String>> item : map.entrySet()) {
                    List<String> tempMapList = new ArrayList<>(item.getValue());
                    if (tempUserList.removeAll(tempMapList)) {
                        item.getValue().addAll(tempUserList);
                        flag = true;
                    }
                }
                if (!flag && user.getEmails().size() != 0) {
                    map.put(user.getName(), user.getEmails());
                }
            }
        }
        mergeUsers.clear();
        for (Map.Entry<String, List<String>> item : map.entrySet()) {
            mergeUsers.add(new User(item.getKey(), item.getValue()));
        }
        return mergeUsers;
    }

    public void mergeToMap() {
        Queue<User> queueUsers = new LinkedList<>(users);
        while (!queueUsers.isEmpty()) {
            mergeUsers(queueUsers.poll());
        }
    }

    private void fillMergedList() {
        mergeUsers.clear();
        mergeToMap();
        for (Map.Entry<String, List<String>> item : map.entrySet()) {
            mergeUsers.add(new User(item.getKey(), item.getValue()));
        }
    }
}
