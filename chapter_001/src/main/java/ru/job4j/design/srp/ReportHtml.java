package ru.job4j.design.srp;

import java.util.function.Predicate;

/**
 * @author RVohmin
 * @since 16.03.2020
 */
public class ReportHtml implements Report {
//    public ReportHtml(MemStore store) {
//    }
//    private Predicate<Employer> filter;
//    private Store store;
//
//    public ReportHtml(Predicate<Employer> filter, Store store) {
//        this.store = store;
//        this.store = store;
//    }

    @Override
    public String generateText(Predicate<Employer> filter, Store store) {
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
        for (Employer employer : store.findBy(filter)) {
            html.append("<p> Name: ").append(employer.getName()).append("</p>")
                    .append("<p> Hired: ").append(employer.getHired()).append("</p>")
                    .append("<p> Fired: ").append(employer.getFired()).append("</p>")
                    .append("<p> Salary: ").append(employer.getSalary()).append("</p>");
        }
        html.append(System.lineSeparator())
                .append("</body>")
                .append(System.lineSeparator())
                .append("</html>")
                .append(System.lineSeparator());
        return html.toString();
    }
}