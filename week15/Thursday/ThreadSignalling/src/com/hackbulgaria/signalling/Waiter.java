package com.hackbulgaria.signalling;

public class Waiter implements Runnable {
    private Signal s;

    public Waiter(Signal s) {
        this.s = s;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Waiter");
        Util.threadMsg("Waiting to be notified...");
        s.doWait();
        Util.threadMsg("Woo! I was notified!");
    }
}
