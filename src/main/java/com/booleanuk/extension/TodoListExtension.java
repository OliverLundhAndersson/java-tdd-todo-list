package com.booleanuk.extension;

import com.booleanuk.core.Task;

import java.util.ArrayList;
import java.util.Collections;

public class TodoListExtension {
    private ArrayList<TaskExtension> tasks = new ArrayList<>();

    public boolean addTask(String name) {
        if (tasks.isEmpty()) {
            TaskExtension task = new TaskExtension(name);
            tasks.add(task);
            return true;
        }
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getName().equals(name)) {
                System.out.println("A task with that name already exists");
                return false;
            } else if (tasks.get(i).getName().compareTo(name) > 0) {
                TaskExtension task = new TaskExtension(name);
                tasks.add(i, task);
                return true;
            }
        }
        TaskExtension task = new TaskExtension(name);
        tasks.add(task);
        return true;
    }

    public ArrayList<TaskExtension> viewTask(boolean ascending) {
        if (ascending) {
            ArrayList<TaskExtension> reverseTasks = new ArrayList<>(tasks);
            Collections.reverse(reverseTasks);
            for (TaskExtension task : reverseTasks) {
                System.out.println(task.getName() + " is completed: " + task.isCompleted());
            }
            return reverseTasks;
        }
        for (TaskExtension task : tasks) {
            System.out.println(task.getName() + " is completed: " + task.isCompleted());
        }
        return tasks;
    }

    public boolean completeTask(String name) {
        for (TaskExtension task : tasks) {
            if (task.getName().equals(name)) {
                return task.setCompleted();
            }
        }
        System.out.println(name + " is not the name of a task.");
        return false;
    }

    public boolean incompleteTask(String name) {
        for (TaskExtension task : tasks) {
            if (task.getName().equals(name)) {
                return task.setIncomplete();
            }
        }
        System.out.println(name + " is not the name of a task.");
        return false;
    }

    public ArrayList<TaskExtension> getCompletedTasks() {
        ArrayList<TaskExtension> completedTasks = new ArrayList<>();
        for (TaskExtension task : tasks) {
            if (task.isCompleted()) {
                completedTasks.add(task);
            }
        }
        return completedTasks;
    }

    public ArrayList<TaskExtension> getIncompleteTasks() {
        ArrayList<TaskExtension> incompleteTasks = new ArrayList<>();
        for (TaskExtension task : tasks) {
            if (!task.isCompleted()) {
                incompleteTasks.add(task);
            }
        }
        return incompleteTasks;
    }

    public boolean search(String name) {
        for (TaskExtension task : tasks) {
            if (task.getName().equals(name)) {
                System.out.println(task.getName() + " is completed: " + task.isCompleted());
                return true;
            }
        }
        System.out.println("Task was not found");
        return false;
    }

    public boolean removeTask(String name) {
        for (TaskExtension task : tasks) {
            if (task.getName().equals(name)) {
                tasks.remove(task);
                System.out.println(name + " was removed from the todo-list");
                return true;
            }
        }
        return false;
    }
}
