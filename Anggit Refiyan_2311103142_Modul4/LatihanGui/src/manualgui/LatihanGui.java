/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package manualgui;

import javax.swing.*;

/**
 *
 * @author Anggit Refiyan
 * 2311103142
 * 07C
 */


public class LatihanGui {

    public static void main(String[] args) {
        String hari [] = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Ahad"};
        JFrame myFrame = new JFrame ("Anggit Frame");
        JOptionPane.showMessageDialog(null, "Peringatan sebentar lagi libur !","Warning", JOptionPane.WARNING_MESSAGE);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        myFrame.setSize(600,600); 
        myFrame.setVisible(true); 
        JPanel myPanel = new JPanel ();
        //myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
        JLabel myLabel = new JLabel("Label Pertama Ku...");
        JButton myButton = new JButton("Button 1st");
        JButton myNdButton = new JButton("Button 2nd");
        JTextArea myTextArea = new JTextArea("My First Text Area...", 5,30);
        JCheckBox myCbxOne = new JCheckBox("Libur Masih Lama");
        JCheckBox myCbxTwo = new JCheckBox("Libur Agak Dekat");
        JCheckBox myCbxThree = new JCheckBox("Libur Sudah Dekat");
        JCheckBox myCbxFour = new JCheckBox("Libur Sudah Tiba");
        JRadioButton myRdoOne = new JRadioButton("Putera", true);
        JRadioButton myRdoTwo = new JRadioButton("Puteri", false);  
        ButtonGroup grpRdo = new ButtonGroup();
        JList daftarHari = new JList(hari);  
        daftarHari.setSelectedIndex(0);
        JComboBox cbbHari = new JComboBox(hari);
        grpRdo.add(myRdoOne);
        grpRdo.add(myRdoTwo);
        myPanel.add(cbbHari); 
        myPanel.add(myLabel);
        myPanel.add(myButton);
        myPanel.add(myNdButton);
        myPanel.add(myTextArea);
        myPanel.add(myCbxOne);
        myPanel.add(myCbxTwo);
        myPanel.add(myCbxThree);
        myPanel.add(myCbxFour);
        myPanel.add(myRdoOne);
        myPanel.add(daftarHari);
        myPanel.add(myRdoTwo);
        myFrame.getContentPane().add(myPanel);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(600,600);
        myFrame.setVisible(true);
    }
    
}
