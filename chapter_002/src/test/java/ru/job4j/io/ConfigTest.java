package ru.job4j.io;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConfigTest {
    @Test
    public void whenPairWithoutComment() {
        String path = "..//app.proppperties";
        Config config = new Config(path);
        config.load();
        assertEquals("Petr Arsentev", config.value("name"));
    }

    @Test
    public void whenPairWithComment() {
        String path = "..//app.proppperties";
        Config config = new Config(path);
        config.load();
        assertEquals("Petr Arsentev", config.value("name"));
    }
}
