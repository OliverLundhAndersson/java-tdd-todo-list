package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TodoListTest {
    public TodoList todoList;
    @Test
    public void addTask() {
        todoList = new TodoList();
        boolean add1 = todoList.addTask("test");
        assertTrue(add1);
    }
}
