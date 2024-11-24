package Guided;

/**
 *
 * @author Fachrullah Zhafran Listiyono_2211103115
 */
import javax.swing.*;

public class latihanGUI {

    public static void main(String[] args) {

        String hari[] = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat",
            "Sabtu", "Ahad"};

        JFrame myFrame = new JFrame("My First Name");
        JPanel myPanel = new JPanel();
// myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
        JLabel myLabel = new JLabel("Label Pertama Ku...");
        JButton myButton = new JButton("Tombol 1st");
        JButton myNdButton = new JButton("Tombol 2nd");
        JTextArea myTextArea = new JTextArea("My First Teks Area...", 5,30);
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
        myFrame.setSize(600, 600);
        myFrame.setVisible(true);

    }

}
