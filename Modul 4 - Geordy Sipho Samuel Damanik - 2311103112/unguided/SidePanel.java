
package unguided;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author dmdm3
 */
public class SidePanel extends JPanel {
    private Color sidebarColor = new Color(44, 62, 80);

    public SidePanel() {
        setPreferredSize(new Dimension(250, getHeight()));
        setBackground(sidebarColor);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        createMenuItems();
    }

    private void createMenuItems() {
        String[] menuItems = {
            "Dashboard", "Data Pasien", "Jadwal Perawatan",
            "Riwayat Perawatan", "Laporan", "Pengaturan"
        };
        
        for (String menuText : menuItems) {
            add(createMenuItem(menuText));
        }
    }

    private JPanel createMenuItem(String text) {
        JPanel menuItem = new JPanel(new FlowLayout(FlowLayout.LEFT));
        menuItem.setMaximumSize(new Dimension(250, 50));
        menuItem.setBackground(sidebarColor);
        
        JLabel iconLabel = new JLabel("  •  ");
        iconLabel.setForeground(Color.WHITE);
        
        JLabel textLabel = new JLabel(text);
        textLabel.setForeground(Color.WHITE);
        textLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        
        menuItem.add(iconLabel);
        menuItem.add(textLabel);
        
        menuItem.addMouseListener(new MenuItemMouseAdapter(menuItem));
        
        return menuItem;
    }
}
