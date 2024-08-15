package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
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
        assertEquals(view2.getFirst().getName(), "test2");
        assertEquals(view2.get(1).getName(), "test1");
        assertEquals(view2.get(2).getName(), "test");
    }
}
