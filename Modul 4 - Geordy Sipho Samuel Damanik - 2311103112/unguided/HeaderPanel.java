
package unguided;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author dmdm3
 */
public class HeaderPanel extends JPanel {
    private JLabel titleLabel;
    private JLabel clockLabel;
    private JLabel dateLabel;
    private Timer timer;
    private Color primaryColor = new Color(41, 128, 185);

    public HeaderPanel() {
        setLayout(new BorderLayout());
        setBackground(primaryColor);
        setPreferredSize(new Dimension(getWidth(), 60));
        setupComponents();
        startClock();
    }

    private void setupComponents() {
        // Title
        titleLabel = new JLabel("SISTEM MANAJEMEN PERAWATAN PASIEN", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        
        // Date & Time Panel
        JPanel dateTimePanel = createDateTimePanel();
        
        add(titleLabel, BorderLayout.CENTER);
        add(dateTimePanel, BorderLayout.EAST);
    }

    private JPanel createDateTimePanel() {
        JPanel dateTimePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        dateTimePanel.setOpaque(false);
        
        clockLabel = new JLabel();
        clockLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        clockLabel.setForeground(Color.WHITE);
        
        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        dateLabel.setForeground(Color.WHITE);
        
        dateTimePanel.add(dateLabel);
        dateTimePanel.add(new JLabel(" | "));
        dateTimePanel.add(clockLabel);
        
        return dateTimePanel;
    }

    private void startClock() {
        timer = new Timer(1000, e -> {
            LocalDateTime now = LocalDateTime.now();
            clockLabel.setText(now.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
            dateLabel.setText(now.format(DateTimeFormatter.ofPattern("dd MMMM yyyy")));
        });
        timer.start();
    }
}
