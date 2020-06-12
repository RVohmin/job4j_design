package ru.job4j.gc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.carrotsearch.sizeof.RamUsageEstimator.sizeOf;

public class Garbage {
    private static final Logger LOG = LoggerFactory.getLogger(Garbage.class);

    public static void info() {
        int mb = 1024 * 1024;
        Runtime runtime = Runtime.getRuntime();
        System.out.println("#### Heap initialization statistic, [Mb] ####");
        System.out.println("Used memory: "
                + (runtime.totalMemory() - runtime.freeMemory()) + " bytes "
                + (runtime.totalMemory() - runtime.freeMemory()) / mb + "Mb");
        System.out.println("Free memory: " + runtime.freeMemory() + " bytes "
                + runtime.freeMemory() / mb + "Mb");
        System.out.println("Total memory: " + runtime.totalMemory() + " bytes "
                + runtime.totalMemory() / mb + "Mb");
        System.out.println("Max memory: " + runtime.maxMemory() + " bytes "
                + runtime.maxMemory() / mb + "Mb");
    }

    public static void main(String[] args) {
//        info();
        System.out.println("size of empty object: " + sizeOf(new User("a")) + " bytes");
        Runtime runtime = Runtime.getRuntime();
        long freeMemory = runtime.freeMemory();
        System.out.println("free Memory " + freeMemory + " bytes");

        int mustBe = (int) freeMemory / 64;
        System.out.println("mustBe " + mustBe + " users");

//        System.out.println("size of empty object: " + sizeOf(new Object()) + " bytes");
        int i;
        for (i = 0; i < mustBe / 8 - 1000; i++) {

            new User("test");
        }
        freeMemory = runtime.freeMemory();
        System.out.println(freeMemory);
        System.out.println(i);
    }
}
