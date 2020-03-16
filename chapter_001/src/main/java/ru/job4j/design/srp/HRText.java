package ru.job4j.design.srp;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author RVohmin
 * @since 16.03.2020
 */
public class HRText implements Report {
    public String generateText(Predicate<Employer> filter, Store store) {
        StringBuilder sortedText = new StringBuilder();
        sortedText.append("Name; Salary;")
                .append(System.lineSeparator());
        List<Employer> list = store.findBy(filter);
        list.sort(new SortReverseEmpSalary());
        for (Employer employer : list) {
            sortedText.append(employer.getName()).append(";")
                    .append(employer.getSalary()).append(";");
        }
        return sortedText.toString();
    }

}
