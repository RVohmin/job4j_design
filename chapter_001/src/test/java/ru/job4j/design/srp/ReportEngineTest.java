package ru.job4j.design.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ReportEngineTest {
    @Test
    public void whenForHRGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker1 = new Employer("Ivan", now, now, 100);
        Employer worker2 = new Employer("Petr", now, now, 200);
        Employer worker3 = new Employer("Alex", now, now, 300);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        HRText hrText = new HRText();
        ReportEngine engine = new ReportEngine(store);
        String expect = "Name; Salary;"
                + System.lineSeparator()
                + worker3.getName() + ";"
                + worker3.getSalary() + ";"
                + worker2.getName() + ";"
                + worker2.getSalary() + ";"
                + worker1.getName() + ";"
                + worker1.getSalary() + ";";
        assertThat(engine.generate(em -> true, hrText), is(expect));
    }

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Ivan", now, now, 100);
        store.add(worker);
        ReportOldText oldText = new ReportOldText();
        ReportEngine engine = new ReportEngine(store);
        String expect = "Name; Hired; Fired; Salary;"
                + System.lineSeparator()
                + worker.getName() + ";"
                + worker.getHired() + ";"
                + worker.getFired() + ";"
                + worker.getSalary() + ";"
                + System.lineSeparator();
        assertThat(engine.generate(em -> true, oldText), is(expect));
    }

    @Test
    public void whenHtmlGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Ivan", now, now, 100);
        store.add(worker);
        ReportHtml html = new ReportHtml();
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder();
        expect.append("<!DOCTYPE html>")
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
                .append(System.lineSeparator())
                .append("</body>")
                .append(System.lineSeparator())
                .append("<p> Name: ").append(worker.getName()).append("</p>")
                .append("<p> Hired: ").append(worker.getHired()).append("</p>")
                .append("<p> Fired: ").append(worker.getFired()).append("</p>")
                .append("<p> Salary: ").append(worker.getSalary()).append("</p>")
                .append(System.lineSeparator())
                .append("</body>")
                .append(System.lineSeparator())
                .append("</html>")
                .append(System.lineSeparator());
        System.out.println(expect);
        assertThat(engine.generate(em -> true, html), is(expect.toString()));
    }
}