/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalpoe;

/**
 *
 * @author RC_Student_lab
 */
public class main1 {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        // Adding tasks
        taskManager.addTask("Create Login", "Mike Smith", 5, "To Do");
        taskManager.addTask("Create Add Features", "Edward Harrison", 8, "Doing");
        taskManager.addTask("Create Reports", "Samantha Paulson", 2, "Done");
        taskManager.addTask("Add Arrays", "Glenda Oberholzer", 11, "To Do");

        // Display all developers
        String[] developers = taskManager.getAllDevelopers();
        for (String developer : developers) {
            System.out.println(developer);
        }

        // Display longest task
        System.out.println(taskManager.displayLongestTask());

        // Search task by name
        System.out.println(taskManager.searchTaskByName("Create Login"));

        // Search tasks by developer
        System.out.println(taskManager.searchTasksByDeveloper("Samantha Paulson"));

        // Delete task
        System.out.println(taskManager.deleteTaskByName("Create Reports"));

        // Display report
        System.out.println(taskManager.displayReport());
    }
}

