package ru.job4j.design.srp;

import java.util.Calendar;
import java.util.function.Predicate;

/**
 * @author RVohmin
 * @since 16.03.2020
 */
public class ReportEngine {
    private Store store;

    /**
     * constructor
     *
     * @param store - Store
     */
    public ReportEngine(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employer> filter, Report report, Department department) {
        return report.generateReport(department.makeReport(filter, store));
    }

    public static void main(String[] args) {
        MemStore store1 = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Ivan", now, now, 100);
        Employer worker2 = new Employer("Petr", now, now, 200);
        Employer worker3 = new Employer("Alex", now, now, 300);
        store1.add(worker);
        store1.add(worker2);
        store1.add(worker3);

        ReportEngine engine = new ReportEngine(store1);
        Department developersDep = new DevelopersDep();
        Department hrDep = new HRDep();
        Department accountDep = new AccountersDep();
        Report reportText = new ReportText();
        Report reportHtml = new ReportHtml();
        Report reportXML = new ReportXML();
        Report reportJSON = new ReportJSON();
        String text = engine.generate(em -> true, reportHtml, accountDep);
        System.out.println(text);
    }
}
