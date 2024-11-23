
package unguided;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author dmdm3
 */
public class PatientCareSchedule extends JFrame {
    private JPanel mainPanel;
    private HeaderPanel headerPanel;
    private SidePanel sidePanel;
    private ContentPanel contentPanel;
    private Color primaryColor = new Color(41, 128, 185);
    private Color secondaryColor = new Color(236, 240, 241);

    public PatientCareSchedule() {
        initializeFrame();
        setupMainPanel();
        setVisible(true);
    }

    private void initializeFrame() {
        setTitle("Sistem Jadwal Perawatan Pasien");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void setupMainPanel() {
        mainPanel = new JPanel(new BorderLayout(0, 0));
        mainPanel.setBackground(secondaryColor);
        
        headerPanel = new HeaderPanel();
        sidePanel = new SidePanel();
        contentPanel = new ContentPanel(primaryColor, secondaryColor);
        
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(sidePanel, BorderLayout.WEST);
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        
        add(mainPanel);
    }
}
