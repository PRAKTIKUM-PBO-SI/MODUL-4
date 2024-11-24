/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UnguidedModul4MV;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author MARSYA VALERIA
 * 2311103105
 * 07C
 */
public class UnguidedM4MV {
     public static void main(String[] args) {
        // Membuat Frame Utama
        JFrame frame = new JFrame("Reminder Pintar");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel Utama
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Komponen Input Tugas
        JTextField taskInput = new JTextField(20);
        String[] priorities = {"Tinggi", "Sedang", "Rendah"};
        JComboBox<String> priorityBox = new JComboBox<>(priorities);
        JButton addButton = new JButton("Tambahkan");
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Tugas:"));
        inputPanel.add(taskInput);
        inputPanel.add(new JLabel("Prioritas:"));
        inputPanel.add(priorityBox);
        inputPanel.add(addButton);

        // Daftar Tugas dengan Checkbox
        JPanel taskPanel = new JPanel();
        taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(taskPanel);

        // Tombol Hapus Tugas Selesai
        JButton doneButton = new JButton("Hapus Tugas Terpilih");

        // Tambahkan Komponen ke Panel
        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(doneButton, BorderLayout.SOUTH);

        // Fungsi Tambah Tugas
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = taskInput.getText();
                String priority = (String) priorityBox.getSelectedItem();
                if (!task.isEmpty()) {
                    // Membuat Checkbox untuk Tugas
                    JCheckBox taskCheckBox = new JCheckBox(task + " [" + priority + "]");
                    taskPanel.add(taskCheckBox);
                    taskPanel.revalidate(); // Update tampilan panel
                    taskPanel.repaint();
                    taskInput.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, "Masukkan tugas terlebih dahulu!");
                }
            }
        });

        // Fungsi Hapus Tugas Selesai
        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Menghapus Checkbox yang Dipilih
                Component[] components = taskPanel.getComponents();
                ArrayList<Component> toRemove = new ArrayList<>();
                for (Component component : components) {
                    if (component instanceof JCheckBox) {
                        JCheckBox checkBox = (JCheckBox) component;
                        if (checkBox.isSelected()) {
                            toRemove.add(checkBox);
                        }
                    }
                }
                for (Component component : toRemove) {
                    taskPanel.remove(component);
                }
                taskPanel.revalidate(); // Update tampilan panel
                taskPanel.repaint();
            }
        });

        // Menampilkan Frame
        frame.add(panel);
        frame.setVisible(true);
    }
}
