package com.hackbulgaria.philosophers;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Philosopher implements Runnable {
    private final int id;
    private Random random = ThreadLocalRandom.current();
    private Fork leftFork;
    private Fork rightFork;

    public Philosopher(int id, Fork a, Fork b) {
        this.id = id;
        this.leftFork = a;
        this.rightFork = b;
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                leftFork.pickUp(this);
                rightFork.pickUp(this);
                eat();
                leftFork.putDown(this);
                rightFork.putDown(this);
            }
        } catch (InterruptedException e) {
            System.out.println("WTF");
        }
    }

    private void think() throws InterruptedException {
        System.out.println(this + " is thinking");
        Thread.sleep(random.nextInt(2000));
    }

    private void eat() throws InterruptedException {
        System.out.println(this + " is eating");
        Thread.sleep(random.nextInt(2000));
    }

    @Override
    public String toString() {
        return "Philosher " + id;
    }
}
