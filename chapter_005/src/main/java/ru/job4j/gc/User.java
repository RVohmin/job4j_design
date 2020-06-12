package ru.job4j.gc;

public class User {
    String name;
    public User(String name) {
        this.name = name;
    }

    @Override
    public void finalize() throws Throwable {
        super.finalize();
        System.out.println("Destroy user object " + name);
    }
}
