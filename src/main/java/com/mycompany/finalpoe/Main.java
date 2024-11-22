/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalpoe;


import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<task3> tasks = new ArrayList<>();
    private static int taskCount = 0;
    private static TaskManager taskManager = new TaskManager();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // User Registration and Login process
        System.out.println("Welcome to the Registration and Login System!");

        System.out.print("Enter first name: ");
        String firstName = input.next();
        
        System.out.print("Enter last name: ");
        String lastName = input.next();
        
        System.out.print("Enter username: ");
        String username = input.next();
        
        System.out.print("Enter password: ");
        String password = input.next();
        
        // Create a Login instance
        Login user = new Login(firstName, lastName, username, password);
        
        // Register user and display messages
        String registrationMessage = user.registerUser(username, password);
        System.out.println(registrationMessage);
        
        // Login process
        System.out.print("Enter username to login: ");
        String loginUsername = input.next();
        
        System.out.print("Enter password to login: ");
        String loginPassword = input.next();
        
        boolean loginSuccess = user.loginUser(loginUsername, loginPassword);
        String loginStatus = user.returnLoginStatus(loginSuccess);
        System.out.println(loginStatus);

        // Proceed to EasyKanban if login is successful
        if (loginSuccess) {
            JOptionPane.showMessageDialog(null, "Login successful! Welcome to EasyKanban.");
            startEasyKanban();
        } else {
            JOptionPane.showMessageDialog(null, "Login failed. Exiting...");
        }
    }

    // Method to handle the EasyKanban task system
    private static void startEasyKanban() {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you wish to enter?"));

        while (taskCount < numTasks) {
            String menu = "Choose an option:\n1) Add tasks\n2) Show report\n3) Display longest task\n4) Search task by name\n5) Delete task\n6) Quit";
            String choice = JOptionPane.showInputDialog(menu);

            switch (choice) {
                case "1" -> addTask();
                case "2" -> showReport();
                case "3" -> displayLongestTask();
                case "4" -> searchTaskByName();
                case "5" -> deleteTask();
                case "6" -> {
                    JOptionPane.showMessageDialog(null, "Exiting the application.");
                    return;
                }
                default -> JOptionPane.showMessageDialog(null, "Invalid option. Please choose again.");
            }
        }

        // Display total hours after entering all tasks
        int totalHours = task3.returnTotalHours(tasks);
        JOptionPane.showMessageDialog(null, "Total hours across all tasks: " + totalHours);
    }

    // Method to handle task addition in EasyKanban
    private static void addTask() {
        String taskName = JOptionPane.showInputDialog("Enter Task Name:");
        String taskDescription = JOptionPane.showInputDialog("Enter Task Description (max 50 characters):");
        String developerDetails = JOptionPane.showInputDialog("Enter Developer Details (First Last Name):");
        int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration (in hours):"));
        String taskStatus = (String) JOptionPane.showInputDialog(null, "Select Task Status:", "Task Status",
                JOptionPane.QUESTION_MESSAGE, null, new String[]{"To Do", "Doing", "Done"}, "To Do");

        task3 task = new task3(taskName, developerDetails, taskDuration, taskStatus, taskCount + 1);

        if (task.checkTaskDescription(taskDescription)) {
            taskManager.addTask(taskName, developerDetails, taskDuration, taskStatus); // Use TaskManager to add the task
            tasks.add(task);
            taskCount++;
            JOptionPane.showMessageDialog(null, task.printTaskDetails());
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
        }
    }

    // Show all tasks in report format
    private static void showReport() {
        String report = taskManager.displayReport();
        JOptionPane.showMessageDialog(null, report);
    }

    // Display the longest task
    private static void displayLongestTask() {
        String longestTaskDetails = taskManager.displayLongestTask();
        JOptionPane.showMessageDialog(null, longestTaskDetails);
    }

    // Search for a task by its name
    private static void searchTaskByName() {
        String taskName = JOptionPane.showInputDialog("Enter Task Name to search:");
        String taskDetails = taskManager.searchTaskByName(taskName);
        JOptionPane.showMessageDialog(null, taskDetails);
    }

    // Delete a task by name
    private static void deleteTask() {
        String taskName = JOptionPane.showInputDialog("Enter Task Name to delete:");
        String deleteMessage = taskManager.deleteTaskByName(taskName);
        JOptionPane.showMessageDialog(null, deleteMessage);
    }
}