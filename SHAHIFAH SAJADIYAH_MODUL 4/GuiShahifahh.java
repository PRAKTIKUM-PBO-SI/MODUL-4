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
public class GuiShahifahh {
    public static void main(String [] args){
        String hari [] = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat","Sabtu", "Ahad"};
    JFrame myFrame = new JFrame ("My First Frame");
    JOptionPane.showMessageDialog(null, "Peringatan sebentar lagi libur !", "Warning", JOptionPane.WARNING_MESSAGE);
    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myFrame.setSize(600,600);
    myFrame.setVisible(true);
    JPanel myPanel = new JPanel();
    JLabel myLabel = new JLabel("Label Pertama Ku...");
    myPanel.add(myLabel);
    JButton myButton = new JButton("Tombol 1st");
    JButton myNdButton = new JButton("Tombol 2nd");
    JTextArea myTextArea = new JTextArea("My First Text Area...", 5,30);
    JCheckBox myCbxOne = new JCheckBox("Libur masih lama");
    JCheckBox myCbxTwo = new JCheckBox("Libur agak dekat");
    JCheckBox myCbxThree = new JCheckBox("Libur sudah dekat");
    JCheckBox myCbxFour = new JCheckBox("Libur sudah tiba");
    JRadioButton myRdoOne = new JRadioButton("Putera", true);
    JRadioButton myRdoTwo = new JRadioButton("Puteri", false);
    ButtonGroup grpRdo = new ButtonGroup();
    grpRdo.add(myRdoOne);
    grpRdo.add(myRdoTwo);
    JList daftarHari = new JList(hari);
    daftarHari.setSelectedIndex(0);
    JComboBox cbbHari = new JComboBox(hari);
    myPanel.add(myLabel);
    myPanel.add(myButton);
    myPanel.add(myNdButton);
    myPanel.add(myTextArea);
    myPanel.add(myCbxOne);
    myPanel.add(myCbxTwo);
    myPanel.add(myCbxThree);
    myPanel.add(myCbxFour);
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
