
package unguided;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

/**
 *
 * @author dmdm3
 */
public class MenuItemMouseAdapter extends MouseAdapter {
    private JPanel menuItem;
    private Color hoverColor = new Color(52, 73, 94);
    private Color normalColor = new Color(44, 62, 80);

    public MenuItemMouseAdapter(JPanel menuItem) {
        this.menuItem = menuItem;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        menuItem.setBackground(hoverColor);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        menuItem.setBackground(normalColor);
    }
}
