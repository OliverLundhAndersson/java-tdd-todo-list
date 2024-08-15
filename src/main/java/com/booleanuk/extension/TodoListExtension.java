package com.booleanuk.extension;

import com.booleanuk.core.Task;

import java.util.ArrayList;
import java.util.Collections;

public class TodoListExtension {
    private ArrayList<TaskExtension> tasks = new ArrayList<>();
    private int idCounter = 0;

    public int addTask(String name) {

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getName().compareTo(name) > 0) {
                TaskExtension task = new TaskExtension(name, idCounter);
                idCounter += 1;
                tasks.add(i, task);
                return idCounter-1;
            }
        }

        TaskExtension task = new TaskExtension(name, idCounter);
        idCounter += 1;
        tasks.add(task);
        return idCounter-1;
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
        ArrayList<TaskExtension> tasksContainingName = new ArrayList<>();
        for (TaskExtension task : tasks) {
            if (task.getName().equals(name)) {
                System.out.println(task.getName() + " was created at" + " is completed: " + task.isCompleted());
                tasksContainingName.add(task);
            }
        }
        if (!tasksContainingName.isEmpty()) {
            return true;
        }
        System.out.println("Task was not found");
        return false;
    }

    public boolean search(int id) {
        for (TaskExtension task : tasks) {
            if (task.getId() == id) {
                System.out.println(task.getName() + " was created at " + " is completed: " + task.isCompleted());
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
