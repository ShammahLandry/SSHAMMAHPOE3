/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.finalpoe;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RC_Student_lab
 */
public class EasyKanban {
    private static final List<Task> tasks = new ArrayList<>();
    private static int taskCount = 0;

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you wish to enter?"));

        while (taskCount < numTasks) {
            String menu = "Choose an option:\n1) Add tasks\n2) Show report\n3) Quit";
            String choice = JOptionPane.showInputDialog(menu);

            switch (choice) {
                case "1" -> addTask();
                case "2" -> JOptionPane.showMessageDialog(null, "Coming Soon");
                case "3" -> {
                    JOptionPane.showMessageDialog(null, "Exiting the application.");
                    return;
                }
                default -> JOptionPane.showMessageDialog(null, "Invalid option. Please choose again.");
            }
        }

        // Display total hours after entering all tasks
        int totalHours = Task.returnTotalHours(tasks);
        JOptionPane.showMessageDialog(null, "Total hours across all tasks: " + totalHours);
    }

    private static void addTask() {
        String taskName = JOptionPane.showInputDialog("Enter Task Name:");
        String taskDescription = JOptionPane.showInputDialog("Enter Task Description (max 50 characters):");
        String developerDetails = JOptionPane.showInputDialog("Enter Developer Details (First Last Name):");
        int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration (in hours):"));
        String taskStatus = (String) JOptionPane.showInputDialog(null, "Select Task Status:", "Task Status",
                JOptionPane.QUESTION_MESSAGE, null, new String[]{"To Do", "Doing", "Done"}, "To Do");

        Task task = new Task(taskCount, taskName, taskDescription, developerDetails, taskDuration, taskStatus);

        if (task.checkTaskDescription()) {
            tasks.add(task);
            taskCount++;
            JOptionPane.showMessageDialog(null, task.printTaskDetails());
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
        }
    }
}