/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalpoe; // Correct package declaration


public class Login {
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    // Constructor
    public Login(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    // Simple username check (could be expanded with more checks)
    public boolean checkUsername(String username) {
        return this.username.equals(username);
    }

    // Password complexity check (simple example)
    public boolean checkPasswordComplexity(String password) {
        // Example: password should be at least 8 characters long
        return password.length() >= 8;
    }

    // Register user method
    public String registerUser(String username, String password) {
        if (!checkPasswordComplexity(password)) {
            return "Password is incorrectly formatted";
        }
        // Implement actual registration logic here
        return "Username successfully captured. Password successfully captured";
    }

    // Login method
    public boolean loginUser(String username, String password) {
        // Check if the username and password match the stored values
        return checkUsername(username) && this.password.equals(password);
    }

    // Return login status as a message
    public String returnLoginStatus(boolean loginSuccess) {
        if (loginSuccess) {
            return "Welcome, " + firstName + " " + lastName + ". It is great to see you again.";
        } else {
            return "Login failed. Please check your username and password.";
        }
    }
}
