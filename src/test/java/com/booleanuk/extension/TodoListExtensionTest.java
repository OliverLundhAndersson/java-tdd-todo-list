package com.booleanuk.extension;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TodoListExtensionTest {
    public TodoListExtension todoList;


    @Test
    public void testAddTask() {
        todoList = new TodoListExtension();
        int add1 = todoList.addTask("test");
        assertEquals(add1, 0);
        int add2 = todoList.addTask("test");
        assertEquals(add2, 1);
    }


    @Test
    public void testViewTask() {
        todoList = new TodoListExtension();
        ArrayList<TaskExtension> view1 = todoList.viewTask(true);
        assertEquals(view1.size(), 0);

        // Test ascending
        todoList.addTask("test");
        todoList.addTask("test2");
        todoList.addTask("test1");
        ArrayList<TaskExtension> view2 = todoList.viewTask(false);
        assertEquals(view2.size(), 3);
        assertEquals(view2.getFirst().getName(), "test");
        assertEquals(view2.get(1).getName(), "test1");
        assertEquals(view2.get(2).getName(), "test2");

        // test descending
        ArrayList<TaskExtension> view3 = todoList.viewTask(true);
        assertEquals(view3.getFirst().getName(), "test2");
        assertEquals(view3.get(1).getName(), "test1");
        assertEquals(view3.get(2).getName(), "test");

        ArrayList<TaskExtension> view4 = todoList.viewTask(false);
        assertEquals(view4.size(), 3);
        assertEquals(view4.getFirst().getName(), "test");
        assertEquals(view4.get(1).getName(), "test1");
        assertEquals(view4.get(2).getName(), "test2");
    }


    @Test
    public void testCompleteTask() {
        todoList = new TodoListExtension();
        int id0 = todoList.addTask("test");
        boolean complete1 = todoList.completeTask(id0);
        assertTrue(complete1);

        boolean complete2 = todoList.completeTask(id0);
        assertFalse(complete2);

        boolean complete3 = todoList.completeTask(1);
        assertFalse(complete3);
    }


    @Test
    public void testIncompleteTask() {
        todoList = new TodoListExtension();
        int id0 = todoList.addTask("test");
        boolean incomplete1 = todoList.incompleteTask(id0);
        assertFalse(incomplete1);

        todoList.completeTask(id0);
        boolean incomplete2 = todoList.incompleteTask(id0);
        assertTrue(incomplete2);

        boolean incomplete3 = todoList.incompleteTask(1);
        assertFalse(incomplete3);
    }


    @Test
    public void testGetCompletedTasks() {
        todoList = new TodoListExtension();
        int id0 = todoList.addTask("test");
        int id1 = todoList.addTask("test2");
        ArrayList<TaskExtension> completed1 = todoList.getCompletedTasks();
        assertEquals(completed1.size(), 0);

        todoList.completeTask(id0);
        ArrayList<TaskExtension> completed2 = todoList.getCompletedTasks();
        assertEquals(completed2.size(), 1);
        assertEquals(completed2.getFirst().getId(), id0);

        todoList.completeTask(id1);
        ArrayList<TaskExtension> completed3 = todoList.getCompletedTasks();
        assertEquals(completed3.size(), 2);
        assertEquals(completed3.getFirst().getId(), id0);
        assertEquals(completed3.get(1).getId(), id1);

        todoList.incompleteTask(id0);
        ArrayList<TaskExtension> completed4 = todoList.getCompletedTasks();
        assertEquals(completed4.size(), 1);
        assertEquals(completed4.getFirst().getId(), id1);
    }


    @Test
    public void testGetIncompleteTasks() {
        todoList = new TodoListExtension();
        int id0 = todoList.addTask("test");
        int id1 = todoList.addTask("test2");
        ArrayList<TaskExtension> incomplete1 = todoList.getIncompleteTasks();
        assertEquals(incomplete1.size(), 2);

        todoList.completeTask(id0);
        ArrayList<TaskExtension> incomplete2 = todoList.getIncompleteTasks();
        assertEquals(incomplete2.size(), 1);
        assertEquals(incomplete2.getFirst().getId(), id1);

        todoList.incompleteTask(id0);
        ArrayList<TaskExtension> incomplete3 = todoList.getIncompleteTasks();
        assertEquals(incomplete3.size(), 2);
        assertEquals(incomplete3.getFirst().getId(), id0);
        assertEquals(incomplete3.get(1).getId(), id1);
    }


    @Test
    public void testSearch() {
        todoList = new TodoListExtension();
        boolean search1 = todoList.search("test");
        assertFalse(search1);

        int id0 = todoList.addTask("test");
        boolean search2 = todoList.search("test");
        assertTrue(search2);
        boolean search4 = todoList.search(id0);
        assertTrue(search4);

        todoList.removeTask(id0);
        boolean search3 = todoList.search("test");
        assertFalse(search3);
        boolean search5 = todoList.search(id0);
        assertFalse(search5);
    }


    @Test
    public void testRemoveTask() {
        todoList = new TodoListExtension();
        boolean remove1 = todoList.removeTask(0);
        assertFalse(remove1);

        int id0 = todoList.addTask("test");
        boolean remove2 = todoList.removeTask(id0);
        assertTrue(remove2);
        boolean remove3 = todoList.removeTask(id0);
        assertFalse(remove3);
    }


    @Test
    public void testDate() {
        todoList = new TodoListExtension();
        int id0 = todoList.addTask("dateTest");
        assertInstanceOf(Date.class, todoList.getTask(id0).getDate());
    }


    @Test
    public void testEditTaskName() {
        todoList = new TodoListExtension();
        int id0 = todoList.addTask("dateTest");
        boolean editName1 = todoList.editTaskName(id0, "Testing new name");
        assertTrue(editName1);
        assertEquals(todoList.getTask(id0).getName(), "Testing new name");
    }
}

