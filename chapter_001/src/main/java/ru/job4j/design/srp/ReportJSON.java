package ru.job4j.design.srp;

import java.util.Map;

/**
 * @author RVohmin
 * @since 17.03.2020
 */
public class ReportJSON implements Report {

    @Override
    public String generateReport(Map<String, String> map) {
        StringBuilder xml = new StringBuilder();
        xml.append("{")
                .append(System.lineSeparator());
        for (Map.Entry<String, String> item : map.entrySet()) {
            String key = item.getKey().substring(2);
            String value = item.getValue().substring(0, item.getValue().length() - 2);
            xml.append("\t{ ").append(key).append(value).append("}, ").append("\n");
        }
        xml.append("}").append("\n")
                .append(System.lineSeparator());
        return xml.toString();
    }
}
