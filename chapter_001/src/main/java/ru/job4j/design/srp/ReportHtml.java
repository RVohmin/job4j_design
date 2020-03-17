package ru.job4j.design.srp;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * @author RVohmin
 * @since 16.03.2020
 */
public class ReportHtml implements Report {
    @Override
    public String generateReport(Map<String, String> map) {
        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>")
                .append(System.lineSeparator())
                .append("<html lang=\"ru\">")
                .append(System.lineSeparator())
                .append("<head>")
                .append(System.lineSeparator())
                .append("<meta charset=\"UTF-8\">")
                .append(System.lineSeparator())
                .append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">")
                .append(System.lineSeparator())
                .append("<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">")
                .append(System.lineSeparator())
                .append("<title>Document</title>")
                .append(System.lineSeparator())
                .append("</head>")
                .append(System.lineSeparator())
                .append("<body>")
                .append(System.lineSeparator());
        for (Map.Entry<String, String> item : map.entrySet()) {
            String key = item.getKey().substring(3);
            String value = item.getValue();
            html.append("<p>").append(key).append(value).append("</p>")
                    .append(System.lineSeparator());
        }
        html.append(System.lineSeparator())
                .append("</body>")
                .append(System.lineSeparator())
                .append("</html>")
                .append(System.lineSeparator());
        return html.toString();
    }
}