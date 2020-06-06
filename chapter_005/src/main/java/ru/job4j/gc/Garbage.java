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
        info();
        System.gc();
        System.out.println(sizeOf(new User("aaaaaaaa")));
        for (int i = 0; i < 7644; i++) {
            new User("test");
        }
    }
}
