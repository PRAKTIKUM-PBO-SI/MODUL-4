/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ManualGUI;
import javax.swing.*;
/**
 *
 * @author Shahifah sajadiyah
 * 2311103116
 * S1SI07C
 */
public class LatihanGui {
    public static void main(String[] args) {
    JFrame myFrame = new JFrame ("My First Frame ");
    JPanel myPanel = new JPanel();
    myPanel.setLayout(new BoxLayout (myPanel, BoxLayout.Y_AXIS));
    JLabel myLabel = new JLabel ("Label Pertama Shahifah Sajadiyah");
    JButton myButton = new JButton ("Tombol 1st");
    JButton myNdButton = new JButton("Tombol 2nd");
    JTextArea myTextArea = new JTextArea("My First Text Area......", 5, 30);
    JCheckBox myCbxOne = new JCheckBox ("Taehyung");
    JCheckBox myCbxTwo = new JCheckBox ("Byun Woo-seok");
    JCheckBox myCbxThree = new JCheckBox ("Ahn Hyo-seop");
    JCheckBox myCbxfour = new JCheckBox ("Kim Soo-hyun");
    myPanel.add(myLabel);
    myPanel.add(myButton);
    myPanel.add(myNdButton);
    myPanel.add(myTextArea);
    myPanel.add(myCbxOne);
    myPanel.add(myCbxTwo);
    myPanel.add(myCbxThree);
    myPanel.add(myCbxfour);
    myFrame.getContentPane().add(myPanel);
    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myFrame.setSize(600,600);
    myFrame.setVisible(true);
    }
}