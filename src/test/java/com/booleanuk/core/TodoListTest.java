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
        ArrayList<Task> view1 = todoList.viewTask();
        assertEquals(view1.size(), 0);
    }
}
