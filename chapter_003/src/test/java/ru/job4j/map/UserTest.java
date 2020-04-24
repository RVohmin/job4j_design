package ru.job4j.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class UserTest {

    @Test
    public void test() {
        User user1 = new User("Petya", 2);
        User user2 = new User("Petya", 2);
        Object object = new Object();

        Map<User, Object> map = new HashMap<>();

        map.put(user1, object);
        map.put(user2, object);

        System.out.println((user1).hashCode());
        System.out.println((user2).hashCode());
        System.out.println(user1.equals(user2));
        System.out.println(map.size());
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE >>> 16));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE >> 1));
    }


}
