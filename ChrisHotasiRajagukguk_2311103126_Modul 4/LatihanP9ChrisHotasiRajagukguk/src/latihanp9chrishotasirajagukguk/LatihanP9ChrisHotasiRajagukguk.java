package latihanp9chrishotasirajagukguk;

import javax.swing.BoxLayout;
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
 * @author Chris Hotasi Rajagukguk
 */
public class LatihanP9ChrisHotasiRajagukguk {
    public static void main(String[] args) {
        String hari [] = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Ahad"};
        JOptionPane.showMessageDialog(null, "Peringatan sebentar lagi libur !", "Warning", JOptionPane.WARNING_MESSAGE);
        JFrame myFrame = new JFrame ("My First Frame");
        JPanel myPanel = new JPanel();
        //myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
        JLabel myLabel = new JLabel("Label Pertama Ku...");
        JButton myButton = new JButton("Tombol 1st");
        JButton myNdButton = new JButton("Tombol 2nd");
        JTextArea myTextArea = new JTextArea("My First Text Area...", 5, 30);
        JCheckBox myCbxOne = new JCheckBox("Libur masih lama");
        JCheckBox myCbxTwo = new JCheckBox("Libur agak dekat");
        JCheckBox myCbxThree = new JCheckBox("Libur sudah dekat");
        JCheckBox myCbxFour = new JCheckBox("Libur sudah tiba");
        JRadioButton myRdoOne = new JRadioButton("Putera", true);
        JRadioButton myRdoTwo = new JRadioButton("Puteri", false);
        JList daftarHari = new JList(hari);
        daftarHari.setSelectedIndex(0);
        JComboBox cbbHari = new JComboBox(hari);
        ButtonGroup grpRdo = new ButtonGroup();
        grpRdo.add(myRdoOne);
        grpRdo.add(myRdoTwo);
        myPanel.add(myLabel);
        myPanel.add(myButton);
        myPanel.add(myTextArea);
        myPanel.add(myCbxOne);
        myPanel.add(myCbxTwo);
        myPanel.add(myCbxThree);
        myPanel.add(myCbxFour);
        myPanel.add(myRdoOne);
        myPanel.add(myRdoTwo);
        myPanel.add(daftarHari);
        myPanel.add(cbbHari);
        myPanel.add(myNdButton);
        myFrame.getContentPane().add(myPanel); 
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(600,600);
        myFrame.setVisible(true);
    }
}
