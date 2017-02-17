package com.hackbulgaria.signalling;

import java.util.concurrent.locks.ReentrantLock;

public class Signal {
    private Object obj = new Object();
    private boolean wasSignalled = false;

    public void doWait() {
        synchronized (obj) {
            try {
                while (!wasSignalled) {
                    obj.wait();
                }
                wasSignalled = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void doNotify() {
        synchronized (obj) {
            while (!wasSignalled) {
                wasSignalled = true;
                obj.notify();
            }
        }
    }

}
