
package unguided;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author dmdm3
 */
public class ContentPanel extends JPanel {
    private Color primaryColor;
    private Color secondaryColor;

    public ContentPanel(Color primaryColor, Color secondaryColor) {
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        
        setupPanel();
        createComponents();
    }

    private void setupPanel() {
        setBackground(secondaryColor);
        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    private void createComponents() {
        add(createStatsPanel(), BorderLayout.NORTH);
        add(createSchedulePanel(), BorderLayout.CENTER);
    }

    private JPanel createStatsPanel() {
        JPanel statsPanel = new JPanel(new GridLayout(1, 3, 15, 0));
        statsPanel.setOpaque(false);
        
        statsPanel.add(createStatCard("Total Pasien", "127", new Color(46, 204, 113)));
        statsPanel.add(createStatCard("Jadwal Hari Ini", "28", new Color(52, 152, 219)));
        statsPanel.add(createStatCard("Sedang Dirawat", "15", new Color(155, 89, 182)));
        
        return statsPanel;
    }

    private JPanel createStatCard(String title, String value, Color color) {
        JPanel card = new JPanel(new GridBagLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(new EmptyBorder(15, 15, 15, 15));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        
        JLabel titleLabel = new JLabel(title);
        titleLabel.setForeground(new Color(127, 140, 141));
        
        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Segoe UI", Font.BOLD, 36));
        valueLabel.setForeground(color);
        
        card.add(titleLabel, gbc);
        card.add(valueLabel, gbc);
        
        return card;
    }

    private JPanel createSchedulePanel() {
        JPanel schedulePanel = new JPanel(new BorderLayout());
        schedulePanel.setBackground(Color.WHITE);
        schedulePanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        JLabel scheduleTitle = new JLabel("Jadwal Perawatan Hari Ini");
        scheduleTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
        
        JTable scheduleTable = createScheduleTable();
        
        schedulePanel.add(scheduleTitle, BorderLayout.NORTH);
        schedulePanel.add(new JScrollPane(scheduleTable), BorderLayout.CENTER);
        
        return schedulePanel;
    }

    private JTable createScheduleTable() {
        String[] columns = {"No.", "Nama Pasien", "Waktu", "Jenis Perawatan", "Ruangan", "Perawat"};
        Object[][] data = {
            {"1", "Ahmad Susanto", "09:00", "Cek Vital Sign", "201", "Ns. Sarah"},
            {"2", "Budi Santoso", "09:30", "Ganti Perban", "205", "Ns. Rina"},
            {"3", "Citra Dewi", "10:00", "Pemberian Obat", "203", "Ns. Maya"},
            {"4", "Diana Putri", "10:30", "Fisioterapi", "Rehab 1", "Ns. Andin"}
        };
        
        JTable table = new JTable(data, columns);
        table.setRowHeight(30);
        table.getTableHeader().setBackground(primaryColor);
        table.getTableHeader().setForeground(Color.WHITE);
        table.setGridColor(new Color(236, 240, 241));
        
        return table;
    }
}
