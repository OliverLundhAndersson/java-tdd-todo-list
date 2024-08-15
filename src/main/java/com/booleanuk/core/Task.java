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
}
