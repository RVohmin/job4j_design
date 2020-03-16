package ru.job4j.tdd;


import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author RVohmin
 * @since 0.1
 */
public class SimpleGenerator implements Template {
    private final Pattern pattern = Pattern.compile("\\$\\{.+?}");

    /**
     * Hello world, ${name}
     *
     * @param template -starting String where we replace template ${...}
     * @param data     Map, where key equals template, value replaced template
     *
     * @return new String where template pelaced to value
     */
    @Override
    public String generate(String template, Map<String, String> data) throws Exception {
        Map<String, String> tempData = new HashMap<>(data);
        StringBuilder stringBuilder = new StringBuilder(template);
        Matcher matcher = pattern.matcher(stringBuilder.toString());
        boolean extra = false;
        while (matcher.find()) {
            String textWithoutBraces = matcher.group()
                    .replace("${", "")
                    .replace("}", "");
            if (data.containsKey(textWithoutBraces)) {
                String replacedText = data.get(textWithoutBraces);
                stringBuilder.replace(matcher.start(), matcher.end(), replacedText);
                tempData.remove(textWithoutBraces);
            } else {
                throw new Exception("Нет такого ключа");
            }
            matcher = pattern.matcher(stringBuilder.toString());
        }
        if (tempData.size() > 0) {
            throw new Exception("В Map есть лишние ключи!");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws Exception {
        Template template = new SimpleGenerator();
        String text = "I am a ${name}, Who are ${subject}?";
        Map<String, String> data = new HashMap<>();
        data.put("name", "Petr");
        data.put("subject", "you");
        String result = template.generate(text, data);
        System.out.println(result);
    }
}
