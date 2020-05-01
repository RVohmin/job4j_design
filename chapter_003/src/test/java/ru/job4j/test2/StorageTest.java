package ru.job4j.test2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StorageTest {
    @Test
    public void whenAdd2UserThenItInStorage() {
        User user1 = new User("user1");
        user1.setEmail("xxx@ya.ru");
        user1.setEmail("foo@gmail.ru");
        user1.setEmail("lol@mail.ru");

        User user2 = new User("user2");
        user2.setEmail("foo@gmail.ru");
        user2.setEmail("ups@pisem.net");

        User user3 = new User("user3");
        user3.setEmail("xyz@pisem.net");
        user3.setEmail("vasya@pupkin.com");

        User user4 = new User("user4");
        user4.setEmail("ups@pisem.net");
        user4.setEmail("aaa@bbb.ru");

        User user5 = new User("user5");
        user5.setEmail("xyz@pisem.net");

        Storage storage = new Storage();
        storage.addUser(user1);
        storage.addUser(user2);
        storage.addUser(user3);
        storage.addUser(user4);
        storage.addUser(user5);
        System.out.println(storage.getMergeUsers());
        assertEquals(5, storage.getUsers().size());
    }
}
