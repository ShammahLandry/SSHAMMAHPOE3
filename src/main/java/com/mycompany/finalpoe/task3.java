/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalpoe;

// Import the List class from the java.util package
import java.util.List;

public class task3 {
    private String taskName;
    private String developer;
    private int duration;
    private String status;
    private int taskID;

    // Constructor
    public task3(String taskName, String developer, int duration, String status, int taskID) {
        this.taskName = taskName;
        this.developer = developer;
        this.duration = duration;
        this.status = status;
        this.taskID = taskID;
    }

    // Getters and Setters (if needed)
    public String getTaskName() {
        return taskName;
    }

    public String getDeveloper() {
        return developer;
    }

    public int getDuration() {
        return duration;
    }

    public String getStatus() {
        return status;
    }

    public int getTaskID() {
        return taskID;
    }

    // Task description validation (ensure it's less than 50 characters)
    public boolean checkTaskDescription(String description) {
        return description.length() <= 50;
    }

    // Print task details
    public String printTaskDetails() {
        return "Task ID: " + taskID + ", Developer: " + developer + ", Task Name: " + taskName + ", Duration: " + duration + ", Status: " + status;
    }

    // Static method to return the total hours
    public static int returnTotalHours(List<task3> tasks) {
        int totalHours = 0;
        for (task3 task : tasks) {
            totalHours += task.getDuration();
        }
        return totalHours;
    }
}