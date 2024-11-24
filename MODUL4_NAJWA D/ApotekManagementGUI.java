/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManualGUI;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
/**
 *
 * @author asus
 */
public class ApotekManagementGUI {
    private JFrame frame;

    public ApotekManagementGUI() {
        // Inisialisasi frame utama
        frame = new JFrame("Sistem Manajemen Apotek - Apotek Najwa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Tambahkan komponen ke frame
        frame.add(createTopPanel(), BorderLayout.NORTH);
        frame.add(createSidePanel(), BorderLayout.WEST);
        frame.add(createMainPanel(), BorderLayout.CENTER);
    }

    public void show() {
        // Tampilkan frame
        frame.setVisible(true);
    }

    private JPanel createTopPanel() {
        // Panel atas untuk informasi
        JPanel topPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel totalObatLabel = new JLabel("<html><h2 style='color:green;'>Total Obat<br>342</h2></html>", JLabel.CENTER);
        JLabel stokMenipisLabel = new JLabel("<html><h2 style='color:blue;'>Stok Menipis<br>28</h2></html>", JLabel.CENTER);
        JLabel kadaluarsaLabel = new JLabel("<html><h2 style='color:red;'>Kedaluwarsa<br>15</h2></html>", JLabel.CENTER);

        topPanel.add(totalObatLabel);
        topPanel.add(stokMenipisLabel);
        topPanel.add(kadaluarsaLabel);

        return topPanel;
    }

    private JPanel createSidePanel() {
        // Panel kiri untuk menu navigasi
        JPanel sidePanel = new JPanel(new GridLayout(6, 1, 5, 5));
        sidePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        sidePanel.setBackground(new Color(60, 80, 100));

        String[] menuItems = {"Dashboard", "Data Obat", "Stok Obat", "Transaksi", "Supplier", "Laporan"};
        for (String item : menuItems) {
            JButton menuButton = new JButton(item);
            menuButton.setForeground(Color.WHITE);
            menuButton.setBackground(new Color(40, 60, 80));
            sidePanel.add(menuButton);
        }

        return sidePanel;
    }

    private JPanel createMainPanel() {
        // Panel utama untuk tabel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel tableTitle = new JLabel("Daftar Obat dengan Stok Menipis", JLabel.LEFT);
        tableTitle.setFont(new Font("Arial", Font.BOLD, 14));
        mainPanel.add(tableTitle, BorderLayout.NORTH);

        String[] columnNames = {"Kode Obat", "Nama Obat", "Kategori", "Stok", "Satuan", "Expired"};
        Object[][] data = {
                {"OBT001", "Paracetamol 500mg", "Analgesik", 50, "Strip", "Dec 2024"},
                {"OBT002", "Amoxicillin 500mg", "Antibiotik", 35, "Strip", "Nov 2024"},
                {"OBT003", "Omeprazole 20mg", "Antasida", 25, "Strip", "Jan 2025"},
                {"OBT004", "Cetirizine 10mg", "Antihistamin", 30, "Strip", "Mar 2025"}
        };

        JTable table = new JTable(new DefaultTableModel(data, columnNames));
        JScrollPane scrollPane = new JScrollPane(table);

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        return mainPanel;
    }
}

