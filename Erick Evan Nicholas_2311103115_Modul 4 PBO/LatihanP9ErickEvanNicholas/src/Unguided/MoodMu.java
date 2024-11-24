/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Unguided;
/**
 * 2311103115
 * @ErickEvanNicholas
 * S1SI-07C
 */
import javax.swing.*;
import java.awt.*;
public class MoodMu {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MoodMu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(new BorderLayout());

        JLabel header = new JLabel("Bagaimana perasaanmu hari ini?", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 18));
        header.setPreferredSize(new Dimension(400, 50));
        frame.add(header, BorderLayout.NORTH);

        JPanel emojiPanel = new JPanel();
        emojiPanel.setLayout(new GridLayout(2, 3, 10, 10));
        String[] emojis = {":)", ":("};

        for (String emoji : emojis) {
            JButton emojiButton = new JButton(emoji);
            emojiButton.setFont(new Font("Arial", Font.PLAIN, 40));
            emojiPanel.add(emojiButton);
        }
        frame.add(emojiPanel, BorderLayout.CENTER);

        JButton saveButton = new JButton("Simpan");
        saveButton.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(saveButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
