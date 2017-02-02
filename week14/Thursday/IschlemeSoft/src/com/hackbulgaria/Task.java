package com.hackbulgaria;

public class Task {
    private String description;
    private long workingTime;

    public Task(String description, long workingTime) {
        this.description = description;
        this.workingTime = workingTime;
    }

    public String getDescription() {
        return description;
    }

    public long getWorkingTime() {
        return workingTime;
    }

    public long getWorkingTimeMillis() {
        return workingTime * 1000;
    }
}
