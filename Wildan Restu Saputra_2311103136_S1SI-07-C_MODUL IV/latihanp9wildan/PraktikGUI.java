/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package latihanp9wildan;

/**
 *
 * @author ACER NITRO 5
 */
import javax.swing.BoxLayout;
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
public class PraktikGUI {

    public static void main(String[] args) {
        String hari [] = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Ahad"};
        JFrame myFrame = new JFrame ("My First Frame");
        JOptionPane.showMessageDialog(null, "Peringatan sebentar lagi libur !",
        "Warning", JOptionPane.WARNING_MESSAGE); 
        JPanel myPanel = new JPanel ();
        //myPanel.setLayout(new BoxLayout (myPanel, BoxLayout.Y_AXIS));
        JLabel myLabel = new JLabel ("Label Pertama ku....");
        JButton myButton = new JButton("Tombol 1ST");
        JButton myNdButton = new JButton("Tombol 2nd");
        JTextArea myTextArea = new JTextArea("My First Text Area...", 5,30);
        JCheckBox myCheckBox = new JCheckBox("Libur Masih lama");
        JCheckBox myCheckBoxTwo = new JCheckBox("Libur agak telat");
        JRadioButton myRdoOne = new JRadioButton("Putera", true); 
        JRadioButton myRdoTwo = new JRadioButton("Puteri", false);
        JList daftarHari = new JList(hari);
        daftarHari.setSelectedIndex(0);
        JComboBox cbbHari = new JComboBox(hari);
        myPanel.add(myLabel);     
        myPanel.add(myButton);
        myPanel.add(myNdButton);
        myPanel.add(myTextArea);
        myPanel.add(myCheckBox);
        myPanel.add(myCheckBoxTwo);
        myPanel.add(myRdoOne);
        myPanel.add(myRdoTwo);
        myPanel.add(daftarHari);
        myPanel.add(cbbHari);
        myFrame.getContentPane().add(myPanel);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(600,600);
        myFrame.setVisible(true);
    }  
}

