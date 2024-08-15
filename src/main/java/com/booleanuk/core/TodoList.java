package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TodoList {
    private ArrayList<Task> tasks = new ArrayList<>();

    public boolean addTask(String name) {
        if (tasks.isEmpty()) {
            Task task = new Task(name);
            tasks.add(task);
            return true;
        }
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getName().equals(name)) {
                System.out.println("A task with that name already exists");
                return false;
            } else if (tasks.get(i).getName().compareTo(name) > 0) {
                Task task = new Task(name);
                tasks.add(i, task);
                return true;
            }
        }
        Task task = new Task(name);
        tasks.add(task);
        return true;
    }

    public ArrayList<Task> viewTask(boolean ascending) {
        if (ascending) {
            ArrayList<Task> reverseTasks = new ArrayList<Task>(tasks);
            Collections.reverse(reverseTasks);
            return reverseTasks;
        }
        return tasks;
    }

    public boolean completeTask(String name) {
        for (Task task : tasks) {
            if (task.getName().equals(name)) {
                return task.setCompleted();
            }
        }
        System.out.println(name + " is not the name of a task.");
        return false;
    }
}

