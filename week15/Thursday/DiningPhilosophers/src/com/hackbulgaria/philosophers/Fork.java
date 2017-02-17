package com.hackbulgaria.philosophers;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Fork {
    private final int id;
    private Lock lock = new ReentrantLock();

    public Fork(int id) {
        this.id = id;
    }

    public void pickUp(Philosopher p) {
        lock.lock();
        System.out.println(p + " picked up " + this);
    }

    public void putDown(Philosopher p) {
        lock.unlock();
        System.out.println(p + " put down " + this);
    }

    @Override
    public String toString() {
        return "Fork " + id;
    }
}
