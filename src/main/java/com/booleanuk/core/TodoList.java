package com.booleanuk.core;

import java.util.ArrayList;
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
            ArrayList<Task> reverseTasks = new ArrayList<>(tasks);
            Collections.reverse(reverseTasks);
            for (Task task : reverseTasks) {
                System.out.println(task.getName() + " is completed: " + task.isCompleted());
            }
            return reverseTasks;
        }
        for (Task task : tasks) {
            System.out.println(task.getName() + " is completed: " + task.isCompleted());
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

    public boolean incompleteTask(String name) {
        for (Task task : tasks) {
            if (task.getName().equals(name)) {
                return task.setIncomplete();
            }
        }
        System.out.println(name + " is not the name of a task.");
        return false;
    }

    public ArrayList<Task> getCompletedTasks() {
        ArrayList<Task> completedTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isCompleted()) {
                completedTasks.add(task);
            }
        }
        return completedTasks;
    }

    public ArrayList<Task> getIncompleteTasks() {
        ArrayList<Task> incompleteTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (!task.isCompleted()) {
                incompleteTasks.add(task);
            }
        }
        return incompleteTasks;
    }

    public boolean search(String name) {
        for (Task task : tasks) {
            if (task.getName().equals(name)) {
                System.out.println(task.getName() + " is completed: " + task.isCompleted());
                return true;
            }
        }
        System.out.println("Task was not found");
        return false;
    }

    public boolean removeTask(String name) {
        return false;
    }
}

