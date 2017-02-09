package com.hackbulgaria.philosophers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        final int PHILOSOPHERS_COUNT = 5;

        ExecutorService service = Executors.newFixedThreadPool(PHILOSOPHERS_COUNT);

        Fork[] forks = new Fork[PHILOSOPHERS_COUNT];

        for (int i = 0; i < PHILOSOPHERS_COUNT; i++) {
            forks[i] = new Fork(i);
        }

        for (int i = 0; i < PHILOSOPHERS_COUNT; i++) {
            Philosopher p = new Philosopher(i, forks[i], forks[(i + 1) % PHILOSOPHERS_COUNT]);
            service.execute(p);
        }

        service.shutdown();
    }
}
