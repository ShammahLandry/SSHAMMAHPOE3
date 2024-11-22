/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.finalpoe;

import com.mycompany.finalpoe.Login;  // Correct import
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.mycompany.finalpoe.Login;  // Correct import statement


/**
 *
 * @author RC_Student_lab
 */
public class Mavenproject1Test {

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        // This test would call the main method of your Mavenproject1 class
        Mavenproject1.main(args); // Make sure the main method is running correctly
    }

    @Test
    public void testUsernameCorrectlyFormatted() {
        Login user = new Login("John", "Doe", "kyl_1", "Ch&&sec@99!");
        boolean result = user.checkUsername("kyl_1");
        assertTrue(result);
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        Login user = new Login("John", "Doe", "kyl_1", "Ch&&sec@99!");
        boolean result = user.checkUsername("wrong_username");
        assertFalse(result);
    }

    @Test
    public void testPasswordMeetsComplexityRequirements() {
        Login user = new Login("John", "Doe", "kyl_1", "Ch&&sec@99!");
        boolean result = user.checkPasswordComplexity("Ch&&sec@99!");
        assertTrue(result);
    }

    @Test
    public void testPasswordDoesNotMeetComplexityRequirements() {
        Login user = new Login("John", "Doe", "kyl_1", "password");
        boolean result = user.checkPasswordComplexity("password");
        assertFalse(result);
    }

    @Test
    public void testLoginSuccessful() {
        Login user = new Login("John", "Doe", "kyl_1", "Ch&&sec@99!");
        boolean result = user.loginUser("kyl_1", "Ch&&sec@99!");
        assertTrue(result);
    }

    @Test
    public void testLoginFailed() {
        Login user = new Login("John", "Doe", "kyl_1", "Ch&&sec@99!");
        boolean result = user.loginUser("kyl_1", "wrongPassword");
        assertFalse(result);
    }

    @Test
    public void testUsernameCorrectlyFormattedReturn() {
        Login user = new Login("John", "Doe", "kyl_1", "Ch&&sec@99!");
        String message = user.registerUser("kyl_1", "Ch&&sec@99!");
        assertTrue(message.contains("Username successfully captured"));
    }

    @Test
    public void testPasswordMeetsComplexityRequirementsReturn() {
        Login user = new Login("John", "Doe", "kyl_1", "Ch&&sec@99!");
        String message = user.registerUser("kyl_1", "Ch&&sec@99!");
        assertTrue(message.contains("Password successfully captured"));
    }

    @Test
    public void testPasswordDoesNotMeetComplexityRequirementsReturn() {
        Login user = new Login("John", "Doe", "kyl_1", "password");
        String message = user.registerUser("kyl_1", "password");
        assertTrue(message.contains("Password is incorrectly formatted"));
    }

    @Test
    public void testLoginStatusMessage() {
        Login user = new Login("John", "Doe", "kyl_1", "Ch&&sec@99!");
        boolean loginSuccess = user.loginUser("kyl_1", "Ch&&sec@99!");
        String message = user.returnLoginStatus(loginSuccess);
        assertEquals("Welcome, John Doe. It is great to see you again.", message);
    }
}