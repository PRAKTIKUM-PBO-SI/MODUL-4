/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManualGUI;
import javax.swing.*;
/**
 *
 * @author Shahifah Sajadiyah
 * 2311103116
 * S1SI07C
 */

public class Guishahifahunguided{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Instagram Login");
        frame.setSize(350, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); 
        JLabel logoLabel = new JLabel("Instagram", SwingConstants.CENTER);
        logoLabel.setBounds(50, 50, 250, 50); 
        frame.add(logoLabel);
        JTextField usernameField = new JTextField();
        usernameField.setBounds(50, 150, 250, 40); 
        frame.add(usernameField);
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(50, 130, 250, 20); 
        frame.add(usernameLabel);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(50, 220, 250, 40); 
        frame.add(passwordField);
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(50, 200, 250, 20); 
        frame.add(passwordLabel);
        JButton loginButton = new JButton("Log In");
        loginButton.setBounds(50, 280, 250, 40); 
        frame.add(loginButton);
        JLabel forgotLabel = new JLabel("Forgot password?", SwingConstants.CENTER);
        forgotLabel.setBounds(50, 340, 250, 20); 
        frame.add(forgotLabel);
        JLabel signupLabel = new JLabel("Don't have an account? Sign Up", SwingConstants.CENTER);
        signupLabel.setBounds(50, 380, 250, 20); 
        frame.add(signupLabel);
        frame.setVisible(true);
    }
}

