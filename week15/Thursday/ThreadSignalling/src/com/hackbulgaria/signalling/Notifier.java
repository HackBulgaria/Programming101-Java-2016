package com.hackbulgaria.signalling;

import java.util.concurrent.ThreadLocalRandom;

public class Notifier implements Runnable {
    private Signal s;

    public Notifier(Signal s) {
        this.s = s;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Notifier");
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(3000, 5001));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Util.threadMsg("Sending notify signal...");
        s.doNotify();
    }
}
