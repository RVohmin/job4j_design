package ru.job4j.design.srp;

import java.util.function.Predicate;

/**
 * @author RVohmin
 * @since 16.03.2020
 */
public class ReportAccounter implements Report {
    private final Double euroPerRouble = 85.3;
    @Override
    public String generateText(Predicate<Employer> filter, Store store) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employer employer : store.findBy(filter)) {
            text.append(employer.getName()).append(";")
                    .append(employer.getHired()).append(";")
                    .append(employer.getFired()).append(";")
                    .append(employer.getSalary() * euroPerRouble).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
