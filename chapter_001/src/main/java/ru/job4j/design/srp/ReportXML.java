package ru.job4j.design.srp;

import java.util.Map;

/**
 * @author RVohmin
 * @since 17.03.2020
 */
public class ReportXML implements Report {

    @Override
    public String generateReport(Map<String, String> map) {
        StringBuilder xml = new StringBuilder();
        xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
                .append(System.lineSeparator())
                .append("<employer>")
                .append(System.lineSeparator());
        for (Map.Entry<String, String> item : map.entrySet()) {
            String key = item.getKey().substring(2);
            String value = item.getValue();
            xml.append("\t<field> ").append(key).append(value).append(" <\\field>")
                    .append(System.lineSeparator());
        }
                xml.append("<\\employer>")
                .append(System.lineSeparator());
        return xml.toString();
    }
}
