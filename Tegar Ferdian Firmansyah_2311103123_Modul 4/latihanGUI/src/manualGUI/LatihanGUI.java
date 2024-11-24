package manualGUI;

/**
 *
 * @author Tegar Ferdian(2311103123)
 */
import javax.swing.*;

public class LatihanGUI {

    public static void main(String[] args) {
        JFrame myFrame = new JFrame("My First Frame");
        JOptionPane.showMessageDialog(null, "Peringatan sebentar lagi libur !", "Warning", JOptionPane.WARNING_MESSAGE);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(600, 600);
        myFrame.setVisible(true);
    }
}
