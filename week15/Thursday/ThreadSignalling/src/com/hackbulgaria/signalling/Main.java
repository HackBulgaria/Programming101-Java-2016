package com.hackbulgaria.signalling;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Signal s = new Signal();

        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(new Notifier(s));
        service.submit(new Waiter(s));

        service.shutdown();
    }
}
