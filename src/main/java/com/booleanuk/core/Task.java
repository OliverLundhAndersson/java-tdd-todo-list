package com.booleanuk.core;

public class Task {
    boolean completed = false;
    private String name;

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean setCompleted() {
        if (completed) {
            System.out.println("Task is already completed");
            return false;
        }
        completed = true;
        return true;
    }

    public boolean setIncomplete() {
        if (!completed) {
            System.out.println("Task is already incomplete");
            return false;
        }
        completed = false;
        return true;
    }
}
