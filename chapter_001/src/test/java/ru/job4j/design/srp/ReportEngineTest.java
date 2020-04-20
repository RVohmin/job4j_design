package ru.job4j.design.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class ReportEngineTest {
    @Test
    public void whenForHRDepGeneratedThenTextReport() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker1 = new Employer("Ivan", now, now, 100);
        store.add(worker1);
        Report hrText = new ReportText();
        Department hrDep = new HRDep();
        ReportEngine engine = new ReportEngine(store);

        String expect = "name: " + worker1.getName()
                + System.lineSeparator()
                + "salary: " + worker1.getSalary() + " euros;\n";
        assertEquals(expect, engine.generate(em -> true, hrText, hrDep));
    }

    @Test
    public void whenForHRDepGeneratedThenHTMLReport() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker1 = new Employer("Ivan", now, now, 100);
        store.add(worker1);
        Report reportHtml = new ReportHtml();
        Department hrDep = new HRDep();
        ReportEngine engine = new ReportEngine(store);
        String html = "<!DOCTYPE html>"
                + System.lineSeparator()
                + "<html lang=\"ru\">"
                + System.lineSeparator()
                + "<head>"
                + System.lineSeparator()
                + "<meta charset=\"UTF-8\">"
                + System.lineSeparator()
                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
                + System.lineSeparator()
                + "<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">"
                + System.lineSeparator()
                + "<title>Document</title>"
                + System.lineSeparator()
                + "</head>"
                + System.lineSeparator()
                + "<body>"
                + System.lineSeparator()
                + "<p>" + "name: " + worker1.getName() + "</p>\n"
                + "<p>" + "salary: " + worker1.getSalary() + " euros;</p>"
                + System.lineSeparator()
                + System.lineSeparator()
                + "</body>"
                + System.lineSeparator()
                + "</html>"
                + System.lineSeparator();
        assertEquals(html, engine.generate(em -> true, reportHtml, hrDep));
    }
}
