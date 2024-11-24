/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package latihangui;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

/**
 *
 * @author Tigris Yedija Maarende
 * 2311103103
 */

public class LatihanGUI {

    public static void main(String[] args) {
        JFrame myFrame = new JFrame ("My Frame");
        JPanel myPanel = new JPanel();
        JLabel myLabel = new JLabel ("Label Pertama Ku....");
        JButton myButton = new JButton("Tombol 1st");
        JButton myNdButton = new JButton("Tombol 2nd");
        JTextArea myTextArea = new JTextArea("My First Text Area...", 5, 30);
        JCheckBox myCbxOne = new JCheckBox ("Libur Masih Lama");
        JCheckBox myCbxTwo = new JCheckBox ("Libur agak dekat");
        JCheckBox myCbxThree = new JCheckBox ("Libur sudah dekat");
        JCheckBox myCbxFour = new JCheckBox ("Libur sudah tiba");
        JRadioButton myRdoOne = new JRadioButton("Putera", true);
        JRadioButton myRdoTwo = new JRadioButton("Puteri", false);
        ButtonGroup grpRdo = new ButtonGroup();
        String[] hari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Ahad"};
        JList<String> daftarHari = new JList<>(hari);
        daftarHari.setSelectedIndex(0);
        JComboBox<String> cbbHari = new JComboBox<>(hari);
        JOptionPane.showMessageDialog(null, "Peringatan sebentar lagi libur!", "Warning", JOptionPane.WARNING_MESSAGE);
        myFrame.getContentPane().add(myPanel);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(600, 600);
        myFrame.setVisible(true);
        myPanel.add(cbbHari);
        myPanel.add(daftarHari);
        grpRdo.add(myRdoOne);
        grpRdo.add(myRdoTwo);
        myPanel.add(myRdoOne);
        myPanel.add(myRdoTwo);
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
