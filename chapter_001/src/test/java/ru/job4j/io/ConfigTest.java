package ru.job4j.io;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConfigTest {
    @Test
    public void whenPairWithoutComment() {
        String path = "..//app.proppperties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("name"),
                is("Petr Arsentev")
        );
    }

    @Test
    public void whenPairWithComment() {
        String path = "..//app.proppperties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("name"),
                is("Petr Arsentev")
        );
    }
}