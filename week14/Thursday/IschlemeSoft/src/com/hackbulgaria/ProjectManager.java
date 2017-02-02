package com.hackbulgaria;

import java.util.ArrayList;
import java.util.List;

public class ProjectManager {
    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().setName("Project Manager");
        double patience = 1.2;

        if (args.length > 0) {
            try {
                patience = Double.parseDouble(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Patience must a double");
            }
        }

        Developer pesho = new Developer("Pesho", Skill.JUNIOR);

        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Write some ugly CSS", 5));
        tasks.add(new Task("Parse XML", 2));
        tasks.add(new Task("Drink coffee", 3));

        long expectedTime = (long)(patience * tasks.stream()
                .mapToLong(Task::getWorkingTimeMillis).sum());

        pesho.assign(tasks);

        long startTime = System.currentTimeMillis();
        Thread peshoAtWork = new Thread(pesho);
        peshoAtWork.start();

        while (peshoAtWork.isAlive()) {
            Util.threadMessage("Waiting...");
            peshoAtWork.join(1000);
            long elapsedTime = System.currentTimeMillis();
            if (((elapsedTime - startTime) > expectedTime) && peshoAtWork.isAlive()) {
                peshoAtWork.interrupt();
                Util.threadMessage(peshoAtWork.getName() + " is useless!. He will be fired.");
            }
        }
    }
}
