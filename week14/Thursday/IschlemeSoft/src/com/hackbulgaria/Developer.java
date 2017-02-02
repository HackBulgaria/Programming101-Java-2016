package com.hackbulgaria;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Developer implements Runnable {
    private String name;
    private Skill skill;
    private List<Task> tasks;

    @Override
    public void run() {
        Thread.currentThread().setName("Developer " + name);
        try {
            for (Task t : tasks) {
                double distraction = ThreadLocalRandom.current().nextDouble(1, 2);
                double timeTaken = t.getWorkingTimeMillis()
                        * skill.multiplier() * distraction;
                Thread.sleep((long) Math.floor(timeTaken));
                Util.threadMessage(t.getDescription());
            }
        } catch (InterruptedException e) {
            Util.threadMessage("Hey! I wasn't done!");
        }
    }

    public void assign(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Developer(String name, Skill skill) {
        this.name = name;
        this.skill = skill;
    }
}
