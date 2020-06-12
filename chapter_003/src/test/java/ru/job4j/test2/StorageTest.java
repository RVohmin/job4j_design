package ru.job4j.test2;

import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class StorageTest {
    @Test
    public void launchBenchmark() throws Exception {

        Options opt = new OptionsBuilder()
                // Specify which benchmarks to run.
                // You can be more specific if you'd like to run only one benchmark per test.
                .include(this.getClass().getName() + ".*")
                // Set the following options as needed
                .mode(Mode.AverageTime)
                .timeUnit(TimeUnit.MICROSECONDS)
                .warmupTime(TimeValue.seconds(1))
                .warmupIterations(2)
                .measurementTime(TimeValue.seconds(1))
                .measurementIterations(2)
                .threads(2)
                .forks(1)
                .shouldFailOnError(true)
                .shouldDoGC(true)
                //.jvmArgs("-XX:+UnlockDiagnosticVMOptions", "-XX:+PrintInlining")
                //.addProfiler(WinPerfAsmProfiler.class)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    @Test
    public void whenAdd2UserThenItInStorage() {
        User user1 = new User("user1");
        user1.setEmail("xxx@ya.ru");
        user1.setEmail("foo@gmail.ru");
        user1.setEmail("lol@mail.ru");

        User user2 = new User("user2");
        user2.setEmail("foo@gmail.ru");
        user2.setEmail("ups@pisem.net");

        User user3 = new User("user3");
        user3.setEmail("xyz@pisem.net");
        user3.setEmail("vasya@pupkin.com");

        User user4 = new User("user4");
        user4.setEmail("ups@pisem.net");
        user4.setEmail("aaa@bbb.ru");

        User user5 = new User("user5");
        user5.setEmail("xyz@pisem.net");

        Storage storage = new Storage();
        storage.addUser(user1);
        storage.addUser(user2);
        storage.addUser(user3);
        storage.addUser(user4);
        storage.addUser(user5);
        System.out.println(storage.getMergeUsers());
//        System.out.println(storage.newMergeUsers(storage.getUsers()));
        assertEquals(5, storage.getUsers().size());
    }


}
