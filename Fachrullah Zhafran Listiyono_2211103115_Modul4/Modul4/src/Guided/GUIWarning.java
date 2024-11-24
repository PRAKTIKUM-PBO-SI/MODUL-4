package Guided;

/**
 *
 * @author Fachrullah Zhafran Listiyono_2211103115
 */
import javax.swing.*;

public class GUIWarning {

    public static void main(String[] args) {

        JFrame myFrame = new JFrame("My First Name");
        JOptionPane.showMessageDialog(null, "Peringatan sebentar lagi libur!", "Warning", JOptionPane.WARNING_MESSAGE);

        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(600, 600);
        myFrame.setVisible(true);

    }

}
