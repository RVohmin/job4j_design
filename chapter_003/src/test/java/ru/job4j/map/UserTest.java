package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class UserTest {
    User user1 = new User("Petya", 2);
    User user2 = new User("Petya", 2);
    Map<User, Object> map = new HashMap<>();
    Object object = new Object();

    @Before
    public void setUp() {
        map.put(user1, object);
        map.put(user2, object);
    }

    @Test
    public void test() {
        System.out.println(map.toString());
    }

}
