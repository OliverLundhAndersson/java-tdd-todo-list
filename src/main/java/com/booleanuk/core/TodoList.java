package com.booleanuk.core;

import java.util.ArrayList;

public class TodoList {
    private ArrayList<Task> tasks = new ArrayList<>();

    public boolean addTask(String name) {
        Task task = new Task(name);
        return true;
    }
}

