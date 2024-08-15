package com.booleanuk.core;

import java.util.ArrayList;

public class TodoList {
    private ArrayList<Task> tasks = new ArrayList<>();

    public boolean addTask(String name) {
        if (tasks.isEmpty()) {
            Task task = new Task(name);
            tasks.add(task);
            return true;
        }
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).name.equals(name)) {
                System.out.println("A task with that name already exists");
                return false;
            } else if (tasks.get(i).name.compareTo(name) > 0) {
                Task task = new Task(name);
                tasks.add(i, task);
                return true;
            }
        }
        Task task = new Task(name);
        tasks.add(task);
        return true;
    }
}

