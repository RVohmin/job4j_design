package ru.job4j.design.srp;

import java.util.Map;
import java.util.function.Predicate;

/**
 * @author RVohmin
 * @since 16.03.2020
 */
public class ReportText implements Report {
    @Override
    public String generateReport(Map<String, String> map) {
        StringBuilder text = new StringBuilder();
        for (Map.Entry<String, String> item : map.entrySet()) {
            String key = item.getKey().substring(3);
            String value = item.getValue();
            text.append(key).append(value).append(System.lineSeparator());
        }
        return text.toString();
    }
}
