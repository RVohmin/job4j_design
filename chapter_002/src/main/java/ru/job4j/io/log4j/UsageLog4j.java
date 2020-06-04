package ru.job4j.io.log4j;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        LOG.debug("User info name : {}, age : {}", name, age);
        byte age1 = 42;
        short age2 = 43;
        long age3 = 120;
        float age4 = 100.0f;
        double age5 = 12.5d;
        char nameLast = 'A';
        boolean bool = true;

        LOG.debug("User info name : {}, age : {}", nameLast, age1);
        LOG.debug("User info name : {}, age : {}", bool, age2);
        LOG.debug("User info  {}", age3);
        LOG.debug("User info name : {}, age : {}", nameLast, age4);
        LOG.debug("User info name : {}, age : {}", nameLast, age5);

    }
}
