// File: KasirApp.java
package KasirApp;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KasirApp extends JFrame {
    // Database connection
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_kasir";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";
    
    // Components
    private JComboBox<String> cmbProduct;
    private JTextField txtPrice, txtQuantity, txtTotal, txtPaid, txtChange;
    private JButton btnCalculate, btnPay, btnClear, btnSave;
    private JTable tblTransactions;
    private DefaultTableModel tableModel;
    private JLabel lblDate;
    
    public KasirApp() {
        initComponents();
        initDatabase();
        loadProducts();
    }
    
    private void initComponents() {
        setTitle("Aplikasi Kasir");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Input panel
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Date
        lblDate = new JLabel();
        updateDate();
        gbc.gridx = 0; gbc.gridy = 0;
        inputPanel.add(new JLabel("Tanggal:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(lblDate, gbc);
        
        // Product selection
        gbc.gridx = 0; gbc.gridy = 1;
        inputPanel.add(new JLabel("Produk:"), gbc);
        cmbProduct = new JComboBox<>();
        gbc.gridx = 1;
        inputPanel.add(cmbProduct, gbc);
        
        // Price
        gbc.gridx = 0; gbc.gridy = 2;
        inputPanel.add(new JLabel("Harga:"), gbc);
        txtPrice = new JTextField(15);
        txtPrice.setEditable(false);
        gbc.gridx = 1;
        inputPanel.add(txtPrice, gbc);
        
        // Quantity
        gbc.gridx = 0; gbc.gridy = 3;
        inputPanel.add(new JLabel("Jumlah:"), gbc);
        txtQuantity = new JTextField(15);
        gbc.gridx = 1;
        inputPanel.add(txtQuantity, gbc);
        
        // Total
        gbc.gridx = 0; gbc.gridy = 4;
        inputPanel.add(new JLabel("Total:"), gbc);
        txtTotal = new JTextField(15);
        txtTotal.setEditable(false);
        gbc.gridx = 1;
        inputPanel.add(txtTotal, gbc);
        
        // Payment
        gbc.gridx = 0; gbc.gridy = 5;
        inputPanel.add(new JLabel("Bayar:"), gbc);
        txtPaid = new JTextField(15);
        gbc.gridx = 1;
        inputPanel.add(txtPaid, gbc);
        
        // Change
        gbc.gridx = 0; gbc.gridy = 6;
        inputPanel.add(new JLabel("Kembalian:"), gbc);
        txtChange = new JTextField(15);
        txtChange.setEditable(false);
        gbc.gridx = 1;
        inputPanel.add(txtChange, gbc);
        
        // Buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        btnCalculate = new JButton("Hitung");
        btnPay = new JButton("Bayar");
        btnClear = new JButton("Bersihkan");
        btnSave = new JButton("Simpan");
        
        buttonPanel.add(btnCalculate);
        buttonPanel.add(btnPay);
        buttonPanel.add(btnClear);
        buttonPanel.add(btnSave);
        
        // Table
        String[] columns = {"No", "Tanggal", "Produk", "Harga", "Jumlah", "Total"};
        tableModel = new DefaultTableModel(columns, 0);
        tblTransactions = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tblTransactions);
        
        // Add panels to main panel
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);
        
        // Add main panel to frame
        add(mainPanel);
        
        // Add listeners
        addListeners();
    }
    
    private void initDatabase() {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Create database and tables if they don't exist
            try (Connection conn = DriverManager.getConnection(DB_URL.replace("/db_kasir", ""), DB_USER, DB_PASS)) {
                Statement stmt = conn.createStatement();
                
                // Create database
                stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS db_kasir");
                
                // Use database
                stmt.executeUpdate("USE db_kasir");
                
                // Create products table
                String createProductsTable = """
                    CREATE TABLE IF NOT EXISTS products (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        price DECIMAL(10,2) NOT NULL
                    )
                    """;
                stmt.executeUpdate(createProductsTable);
                
                // Create transactions table
                String createTransactionsTable = """
                    CREATE TABLE IF NOT EXISTS transactions (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        date DATE NOT NULL,
                        product_name VARCHAR(100) NOT NULL,
                        price DECIMAL(10,2) NOT NULL,
                        quantity INT NOT NULL,
                        total DECIMAL(10,2) NOT NULL
                    )
                    """;
                stmt.executeUpdate(createTransactionsTable);
                
                // Insert sample products if table is empty
                ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM products");
                rs.next();
                if (rs.getInt(1) == 0) {
                    String[] insertProducts = {
                        "INSERT INTO products (name, price) VALUES ('Nasi Goreng', 15000)",
                        "INSERT INTO products (name, price) VALUES ('Mie Goreng', 12000)",
                        "INSERT INTO products (name, price) VALUES ('Es Teh', 3000)",
                        "INSERT INTO products (name, price) VALUES ('Es Jeruk', 4000)"
                    };
                    for (String sql : insertProducts) {
                        stmt.executeUpdate(sql);
                    }
                }
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private void loadProducts() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT name FROM products");
            
            cmbProduct.removeAllItems();
            cmbProduct.addItem("Pilih Produk");
            while (rs.next()) {
                cmbProduct.addItem(rs.getString("name"));
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading products: " + e.getMessage());
        }
    }
    
    private void loadTransactions() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM transactions ORDER BY date DESC");
            
            // Clear existing table data
            tableModel.setRowCount(0);
            
            int no = 1;
            while (rs.next()) {
                Object[] row = {
                    no++,
                    rs.getDate("date"),
                    rs.getString("product_name"),
                    rs.getDouble("price"),
                    rs.getInt("quantity"),
                    rs.getDouble("total")
                };
                tableModel.addRow(row);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading transactions: " + e.getMessage());
        }
    }
    
    private void addListeners() {
        cmbProduct.addActionListener(e -> {
            String selectedProduct = (String) cmbProduct.getSelectedItem();
            if (selectedProduct != null && !selectedProduct.equals("Pilih Produk")) {
                try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
                    PreparedStatement pstmt = conn.prepareStatement("SELECT price FROM products WHERE name = ?");
                    pstmt.setString(1, selectedProduct);
                    ResultSet rs = pstmt.executeQuery();
                    
                    if (rs.next()) {
                        txtPrice.setText(String.valueOf(rs.getDouble("price")));
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error getting price: " + ex.getMessage());
                }
            } else {
                txtPrice.setText("");
            }
        });
        
        btnCalculate.addActionListener(e -> calculateTotal());
        btnPay.addActionListener(e -> processPayment());
        btnClear.addActionListener(e -> clearForm());
        btnSave.addActionListener(e -> saveTransaction());
        
        // Start timer to update date
        Timer timer = new Timer(1000, e -> updateDate());
        timer.start();
    }
    
    private void calculateTotal() {
        try {
            double price = Double.parseDouble(txtPrice.getText());
            int quantity = Integer.parseInt(txtQuantity.getText());
            
            if (quantity <= 0) {
                JOptionPane.showMessageDialog(this, "Jumlah harus lebih dari 0");
                return;
            }
            
            double total = price * quantity;
            txtTotal.setText(String.valueOf(total));
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Masukkan angka yang valid");
        }
    }
    
    private void processPayment() {
        try {
            double total = Double.parseDouble(txtTotal.getText());
            double paid = Double.parseDouble(txtPaid.getText());
            
            if (paid < total) {
                JOptionPane.showMessageDialog(this, "Pembayaran kurang");
                return;
            }
            
            double change = paid - total;
            txtChange.setText(String.valueOf(change));
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Masukkan angka yang valid");
        }
    }
    
    private void saveTransaction() {
        try {
            String productName = (String) cmbProduct.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText());
            int quantity = Integer.parseInt(txtQuantity.getText());
            double total = Double.parseDouble(txtTotal.getText());
            
            if (productName.equals("Pilih Produk")) {
                JOptionPane.showMessageDialog(this, "Pilih produk terlebih dahulu");
                return;
            }
            
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
                String sql = "INSERT INTO transactions (date, product_name, price, quantity, total) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                
                pstmt.setDate(1, new java.sql.Date(new Date().getTime()));
                pstmt.setString(2, productName);
                pstmt.setDouble(3, price);
                pstmt.setInt(4, quantity);
                pstmt.setDouble(5, total);
                
                pstmt.executeUpdate();
                
                JOptionPane.showMessageDialog(this, "Transaksi berhasil disimpan");
                loadTransactions();
                clearForm();
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error saving transaction: " + e.getMessage());
        }
    }
    
    private void clearForm() {
        cmbProduct.setSelectedIndex(0);
        txtPrice.setText("");
        txtQuantity.setText("");
        txtTotal.setText("");
        txtPaid.setText("");
        txtChange.setText("");
    }
    
    private void updateDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        lblDate.setText(sdf.format(new Date()));
    }
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }
        
        SwingUtilities.invokeLater(() -> {
            new KasirApp().setVisible(true);
        });
    }
}