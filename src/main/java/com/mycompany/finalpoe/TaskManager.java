/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalpoe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskManager {
    // List to hold all the tasks
    private List<task3> tasks = new ArrayList<>();

    // Method to add a task
    public void addTask(String taskName, String developer, int duration, String status) {
        int taskID = tasks.size() + 1;  // Generate task ID (assuming IDs are sequential)
        task3 task = new task3(taskName, developer, duration, status, taskID);
        tasks.add(task);
    }

    // Method to get all developer names
    public String[] getAllDevelopers() {
        if (tasks.isEmpty()) {
            return new String[0];  // Return empty array if no tasks
        }
        String[] developers = new String[tasks.size()];
        for (int i = 0; i < tasks.size(); i++) {
            developers[i] = tasks.get(i).getDeveloper();
        }
        return developers;
    }

    // Method to display the developer and duration for the task with the longest duration
    public String displayLongestTask() {
        if (tasks.isEmpty()) {
            return "No tasks available.";
        }

        task3 longestTask = tasks.get(0);
        for (task3 task : tasks) {
            if (task.getDuration() > longestTask.getDuration()) {
                longestTask = task;
            }
        }
        return "Developer: " + longestTask.getDeveloper() + ", Duration: " + longestTask.getDuration();
    }

    // Method to search for a task by name and return the task's developer and name
    public String searchTaskByName(String taskName) {
        for (task3 task : tasks) {
            if (task.getTaskName().equalsIgnoreCase(taskName)) {
                return task.getDeveloper() + ", " + task.getTaskName();
            }
        }
        return "Task not found";
    }

    // Method to search for tasks assigned to a developer and display their names and status
    public String searchTasksByDeveloper(String developer) {
        StringBuilder result = new StringBuilder();
        for (task3 task : tasks) {
            if (task.getDeveloper().equalsIgnoreCase(developer)) {
                result.append(task.getTaskName()).append(", Status: ").append(task.getStatus()).append("\n");
            }
        }
        return result.length() > 0 ? result.toString() : "No tasks found for developer.";
    }

    // Method to delete a task by name
    public String deleteTaskByName(String taskName) {
        Iterator<task3> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            task3 task = iterator.next();
            if (task.getTaskName().equalsIgnoreCase(taskName)) {
                iterator.remove(); // Removes the current task from the list
                return "Task '" + taskName + "' has been deleted.";
            }
        }
        return "Task with name " + taskName + " not found.";
    }

    // Method to display a report of all tasks
    public String displayReport() {
        if (tasks.isEmpty()) {
            return "No tasks to display.";
        }

        StringBuilder report = new StringBuilder();
        for (task3 task : tasks) {
            report.append("Task ID: ").append(task.getTaskID())
                    .append(", Developer: ").append(task.getDeveloper())
                    .append(", Task Name: ").append(task.getTaskName())
                    .append(", Duration: ").append(task.getDuration())
                    .append(", Status: ").append(task.getStatus())
                    .append("\n");
        }
        return report.toString();
    }
}