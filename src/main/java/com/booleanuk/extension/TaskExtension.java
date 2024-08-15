package com.booleanuk.extension;

import java.util.Date;

public class TaskExtension {
    private boolean completed = false;
    private String name;
    private final int id;
    private Date date;

    public TaskExtension(String name, int id) {
        this.name = name;
        this.id = id;
        this.date = new Date();
    }

    public boolean isCompleted() {
        return completed;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
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
