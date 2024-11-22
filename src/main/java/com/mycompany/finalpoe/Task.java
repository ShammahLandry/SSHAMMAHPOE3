/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalpoe;

import java.util.List;

public class Task {
    private int taskId;
    private String taskName;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration; // in hours
    private String taskStatus;

    public Task(int taskId, String taskName, String taskDescription, String developerDetails, int taskDuration, String taskStatus) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
    }

    // Check if task description is under 50 characters
    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    // Print task details
    public String printTaskDetails() {
        return "Task ID: " + taskId + "\nName: " + taskName + "\nDescription: " + taskDescription
                + "\nDeveloper: " + developerDetails + "\nDuration: " + taskDuration + " hours\nStatus: " + taskStatus;
    }

    // Static method to calculate total hours for all tasks
    public static int returnTotalHours(List<Task> tasks) {
        int totalHours = 0;
        for (Task task : tasks) {
            totalHours += task.taskDuration;
        }
        return totalHours;
    }
}
