/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package latihangui;

/**
 *
 * @author Muhammad Raflan Kemal
 * 2311103132
 * 07C
 */

import javax.swing.*;
public class LatihanGUI {
    public static void main(String[] args) {
        JFrame myFrame = new JFrame ("My First Frame");
        JPanel myPanel = new JPanel ();
        JOptionPane.showMessageDialog(null, "Peringatan Sebentar Lagi Libur!!!!", "Warning", JOptionPane.WARNING_MESSAGE);
        JLabel myLabel = new JLabel("Label Pertama Ku...");
        JButton myButton = new JButton ("Tombol 1st");
        JButton myNdButton = new JButton ("Tombol 2nd");
        JTextArea myTextArea = new JTextArea("My First Text Area...", 5, 30);
        JCheckBox myCbxOne = new JCheckBox("Libur Masih lama");
        JCheckBox myCbxTwo = new JCheckBox("Libur Agak Dekat");
        JCheckBox myCbxThree = new JCheckBox("Libur Sudah Dekat");
        JCheckBox myCbxFour = new JCheckBox("Libur Sudah Tiba");
        myPanel.add(myLabel);
        myPanel.add(myButton);
        myPanel.add(myNdButton);
        myPanel.add(myTextArea);
        myPanel.add(myCbxOne);
        myPanel.add(myCbxTwo);
        myPanel.add(myCbxThree);
        myPanel.add(myCbxFour);
        myFrame.getContentPane().add(myPanel);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(600,600);
        myFrame.setVisible(true);
    }
}