package manualGUI;
import javax.swing.*;
/**
 * @author Levina Maheswari
 * 2311103110/S1SI07C
 */
public class main{
    public static void main(String[] args){
       JFrame myFrame = new JFrame ("My first Frame");
       JPanel myPanel = new JPanel();
       JOptionPane.showMessageDialog(null,"Peringatan Sebentar Lagi Libur!","Warning",JOptionPane.WARNING_MESSAGE);
       JLabel myLabel = new JLabel("Label Pertama levina...");
       JButton myButton = new JButton("Tombol 1st");
       JButton myNdButton = new JButton("Tombol 2nd");
       JTextArea myTextArea = new JTextArea("My First Text Area",5,30);
       JCheckBox myCbxOne = new JCheckBox ("Libur Masih Lama");
       JCheckBox myCbxTwo = new JCheckBox ("Libur Agak dekat");
       JCheckBox myCbxThree = new JCheckBox ("Libur Sudah Dekat");
       JCheckBox myCbxFour = new JCheckBox ("Libur Sudah Tiba");
       JRadioButton myRdoOne = new JRadioButton ("Putera",true);
       JRadioButton myRdoTwo = new JRadioButton ("Puteri",false);
       String hari[] = {"Senin", "Selasa", "Rabu","Kamis","Jumat","Sabtu","Ahad"};
       JList daftarHari = new JList(hari);
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
