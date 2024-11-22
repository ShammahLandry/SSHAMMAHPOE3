/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.finalpoe;
import com.mycompany.finalpoe.Login;
import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author RC_Student_lab
 */
public class Mavenproject1 {
    
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
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
        }


}
}
