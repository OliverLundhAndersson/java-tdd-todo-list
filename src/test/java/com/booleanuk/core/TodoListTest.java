package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TodoListTest {
    public TodoList todoList;
    @Test
    public void testAddTask() {
        todoList = new TodoList();
        boolean add1 = todoList.addTask("test");
        assertTrue(add1);

        boolean add2 = todoList.addTask("test");
        assertFalse(add2);
    }

    @Test
    public void testViewTask() {
        todoList = new TodoList();
        ArrayList<Task> view1 = todoList.viewTask(true);
        assertEquals(view1.size(), 0);

        // Test ascending
        todoList.addTask("test");
        todoList.addTask("test2");
        todoList.addTask("test1");
        ArrayList<Task> view2 = todoList.viewTask(false);
        assertEquals(view2.size(), 3);
        assertEquals(view2.getFirst().getName(), "test");
        assertEquals(view2.get(1).getName(), "test1");
        assertEquals(view2.get(2).getName(), "test2");

        // test descending
        ArrayList<Task> view3 = todoList.viewTask(true);
        assertEquals(view3.getFirst().getName(), "test2");
        assertEquals(view3.get(1).getName(), "test1");
        assertEquals(view3.get(2).getName(), "test");

        ArrayList<Task> view4 = todoList.viewTask(false);
        assertEquals(view4.size(), 3);
        assertEquals(view4.getFirst().getName(), "test");
        assertEquals(view4.get(1).getName(), "test1");
        assertEquals(view4.get(2).getName(), "test2");
    }

    @Test
    public void testCompleteTask() {
        todoList = new TodoList();
        todoList.addTask("test");
        boolean complete1 = todoList.completeTask("test");
        assertTrue(complete1);

        boolean complete2 = todoList.completeTask("test");
        assertFalse(complete2);

        boolean complete3 = todoList.completeTask("test1");
        assertFalse(complete3);
    }

    @Test
    public void testIncompleteTask() {
        todoList = new TodoList();
        todoList.addTask("test");
        boolean incomplete1 = todoList.incompleteTask("test");
        assertFalse(incomplete1);

        todoList.completeTask("test");
        boolean incomplete2 = todoList.incompleteTask("test");
        assertTrue(incomplete2);

        boolean incomplete3 = todoList.incompleteTask("test1");
        assertFalse(incomplete3);
    }

    @Test
    public void testGetCompletedTasks() {
        todoList = new TodoList();
        todoList.addTask("test");
        todoList.addTask("test2");
        ArrayList<Task> completed1 = todoList.getCompletedTasks();
        assertEquals(completed1.size(), 0);

        todoList.completeTask("test");
        ArrayList<Task> completed2 = todoList.getCompletedTasks();
        assertEquals(completed2.size(), 1);
        assertEquals(completed2.getFirst().getName(), "test");

        todoList.completeTask("test2");
        ArrayList<Task> completed3 = todoList.getCompletedTasks();
        assertEquals(completed3.size(), 2);
        assertEquals(completed3.getFirst().getName(), "test");
        assertEquals(completed3.get(1).getName(), "test2");

        todoList.incompleteTask("test");
        ArrayList<Task> completed4 = todoList.getCompletedTasks();
        assertEquals(completed4.size(), 1);
        assertEquals(completed4.getFirst().getName(), "test2");
    }

    @Test
    public void testGetIncompleteTasks() {
        todoList = new TodoList();
        todoList.addTask("test");
        todoList.addTask("test2");
        ArrayList<Task> incomplete1 = todoList.getIncompleteTasks();
        assertEquals(incomplete1.size(), 2);

        todoList.completeTask("test");
        ArrayList<Task> incomplete2 = todoList.getIncompleteTasks();
        assertEquals(incomplete2.size(), 1);
        assertEquals(incomplete2.getFirst().getName(), "test2");

        todoList.incompleteTask("test");
        ArrayList<Task> incomplete3 = todoList.getIncompleteTasks();
        assertEquals(incomplete3.size(), 2);
        assertEquals(incomplete3.getFirst().getName(), "test");
        assertEquals(incomplete3.get(1).getName(), "test2");
    }

    @Test
    public void testSearch() {
        todoList = new TodoList();
        boolean search1 = todoList.search("test");
        assertFalse(search1);
    }
}
