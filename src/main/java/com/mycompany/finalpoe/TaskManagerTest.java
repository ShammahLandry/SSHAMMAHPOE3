/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalpoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {

    TaskManager manager;

    @BeforeEach
    public void setUp() {
        manager = new TaskManager(); // Initializes the manager with test data
    }

    @Test
    public void testDeveloperArrayCorrectlyPopulated() {
        // Expected developer names from the test data
        String[] expectedDevelopers = {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};
        
        // Get developers from manager
        String[] developers = manager.getAllDevelopers();

        // Assert that the developer array matches the expected result
        assertArrayEquals(expectedDevelopers, developers);
    }

    @Test
    public void testDisplayDeveloperAndDurationForLongestDurationTask() {
        // Test to find the task with the longest duration
        String expectedOutput = "Developer: Glenda Oberholzer, Duration: 11";
        
        // Capture the system output when displaying the longest task
        // For simplicity, assume it's printed to console in the current implementation.
        assertEquals(expectedOutput, manager.displayLongestTask());
    }

    @Test
    public void testSearchForTask() {
        // Search for "Create Login"
        String expectedSearchResult = "Mike Smith, Create Login";
        
        // Capture the result of the search
        String result = manager.searchTaskByName("Create Login");

        // Assert that the result matches expected output
        assertEquals(expectedSearchResult, result);
    }

    @Test
    public void testSearchTasksByDeveloper() {
        // Search for tasks assigned to "Samantha Paulson"
        String expectedResult = "Create Reports, Status: Done";
        
        // Capture the result of the search
        String result = manager.searchTasksByDeveloper("Samantha Paulson");

        // Assert the result contains the correct task name and status
        assertEquals(expectedResult, result);
    }

    @Test
    public void testDeleteTaskFromArray() {
        // Test deleting task "Create Reports"
        String taskToDelete = "Create Reports";
        String expectedResult = "Task 'Create Reports' has been deleted.";

        // Delete task and check the result
        String result = manager.deleteTaskByName(taskToDelete);

        // Assert that the task is successfully deleted
        assertEquals(expectedResult, result);
    }

    @Test
    public void testDisplayReport() {
        // After deleting "Create Reports", we expect the remaining tasks in the report
        String expectedReport = "Task ID: 1, Developer: Mike Smith, Task Name: Create Login, Duration: 5, Status: To Do\n"
                                + "Task ID: 2, Developer: Edward Harrison, Task Name: Create Add Features, Duration: 8, Status: Doing\n"
                                + "Task ID: 4, Developer: Glenda Oberholzer, Task Name: Add Arrays, Duration: 11, Status: To Do";

        // Get the report after deleting "Create Reports"
        String report = manager.displayReport();

        // Assert that the report matches the expected output
        assertEquals(expectedReport, report);
    }
}
