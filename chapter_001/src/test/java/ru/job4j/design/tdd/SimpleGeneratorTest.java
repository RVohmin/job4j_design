package ru.job4j.design.tdd;

import org.junit.Test;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleGeneratorTest {
    @Test
    public void whenTakeTextWithDateShouldReplaceParamsToData() throws Exception {
        Template template = new SimpleGenerator();
        String text = "I am a ${name}, Who are ${subject}?";
        Map<String, String> data = Map.of("name", "Petr", "subject", "you");
        String checked = "I am a Petr, Who are you?";
        String result = template.generate(text, data);
        assertThat(result, is(checked));
    }

    @Test
    public void whenTakeTextWithMachDateShouldReplaceParamsToData() throws Exception {
        Template template = new SimpleGenerator();
        String text = " Help, ${sos}, ${sos}, ${sos}";
        Map<String, String> data = Map.of("sos", "Aaaa");
        String checked = " Help, Aaaa, Aaaa, Aaaa";
        String result = template.generate(text, data);
        assertThat(result, is(checked));
    }

    @Test(expected = Exception.class)
    public void whenMapEmptyThenException() throws Exception {
        Template template = new SimpleGenerator();
        String text = " Help, ${sos}, ${sos}, ${sos}";
        Map<String, String> data = Map.of("cos", "Aaaa");
        String checked = " Help, Ааaа, Ааaа, Ааaа";
        String result = template.generate(text, data);
        assertThat(result, is(checked));
    }

    @Test(expected = Exception.class)
    public void whenMapHasExtraKeysThenException() throws Exception {
        Template template = new SimpleGenerator();
        String text = " Help, ${sos}, ${sos}, ${sos}";
        Map<String, String> data = Map.of("sos", "Aaaa", "extra", "Aaaa");
        String checked = " Help, Аааa, Аааa, Аааa";
        String result = template.generate(text, data);
        assertThat(result, is(checked));
    }

}