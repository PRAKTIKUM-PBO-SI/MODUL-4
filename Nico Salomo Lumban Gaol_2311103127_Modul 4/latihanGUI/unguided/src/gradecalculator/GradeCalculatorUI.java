package gradecalculator;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;

public class GradeCalculatorUI extends JFrame {
    private JPanel mainPanel, inputPanel, resultPanel;
    private JTextField[] scoreFields;
    private JLabel[] subjectLabels;
    private JLabel averageLabel, gradeLabel;
    private final String[] subjects = {
        "Matematika", "Ips", "Ipa", "Penjas", "Inggris"
    };
    private final Color[] pastelColors = {
        new Color(255, 190, 190), 
        new Color(190, 255, 190), 
        new Color(190, 190, 255), 
        new Color(255, 255, 190), 
        new Color(255, 190, 255)  
    };
    
    public GradeCalculatorUI() {
        setTitle("✏️ Student Grade Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 700);
        setLocationRelativeTo(null);
        
        // Main Panel Setup
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(248, 249, 250));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
       
        JLabel headerLabel = createStyledLabel("Student Grade Calculator", 24);
        JLabel subHeaderLabel = createStyledLabel("Enter your scores below (0-100)", 14);
        
        
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(subjects.length, 1, 10, 10));
        inputPanel.setBackground(new Color(248, 249, 250));
        
        scoreFields = new JTextField[subjects.length];
        subjectLabels = new JLabel[subjects.length];
        
        
        for (int i = 0; i < subjects.length; i++) {
            JPanel subjectPanel = createSubjectPanel(i);
            inputPanel.add(subjectPanel);
        }
        
        resultPanel = new JPanel();
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
        resultPanel.setBackground(new Color(248, 249, 250));
        resultPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        
        averageLabel = createStyledLabel("Average Score: -", 18);
        gradeLabel = createStyledLabel("Final Grade: -", 18);
        
        
        JButton calculateButton = new JButton("Calculate Grade");
        calculateButton.setFont(new Font("Arial", Font.BOLD, 16));
        calculateButton.setForeground(Color.WHITE);
        calculateButton.setBackground(new Color(79, 129, 189));
        calculateButton.setFocusPainted(false);
        calculateButton.setBorder(new RoundedBorder(10));
        calculateButton.setMaximumSize(new Dimension(200, 40));
        calculateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
        calculateButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                calculateButton.setBackground(new Color(68, 114, 196));
            }
            public void mouseExited(MouseEvent e) {
                calculateButton.setBackground(new Color(79, 129, 189));
            }
        });
        
        
        JButton resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Arial", Font.BOLD, 16));
        resetButton.setForeground(new Color(79, 129, 189));
        resetButton.setBackground(Color.WHITE);
        resetButton.setFocusPainted(false);
        resetButton.setBorder(new RoundedBorder(10));
        resetButton.setMaximumSize(new Dimension(200, 40));
        resetButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Add components to result panel
        resultPanel.add(averageLabel);
        resultPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        resultPanel.add(gradeLabel);
        
        
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPanel.add(subHeaderLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(inputPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(calculateButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(resetButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(resultPanel);
        
        
        add(mainPanel);
    }
    
    private JPanel createSubjectPanel(int index) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 0));
        panel.setBackground(pastelColors[index]);
        panel.setBorder(new RoundedBorder(15));
        panel.setMaximumSize(new Dimension(400, 60));
        
        subjectLabels[index] = new JLabel(subjects[index]);
        subjectLabels[index].setFont(new Font("Arial", Font.BOLD, 14));
        subjectLabels[index].setBorder(new EmptyBorder(10, 15, 10, 0));
        
        scoreFields[index] = new JTextField(4);
        scoreFields[index].setFont(new Font("Arial", Font.PLAIN, 14));
        scoreFields[index].setBorder(new EmptyBorder(5, 5, 5, 5));
        
        JPanel scorePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        scorePanel.setBackground(pastelColors[index]);
        scorePanel.add(scoreFields[index]);
        
        panel.add(subjectLabels[index], BorderLayout.WEST);
        panel.add(scorePanel, BorderLayout.EAST);
        
        return panel;
    }
    
    private JLabel createStyledLabel(String text, int fontSize) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, fontSize));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }
    
    
    private static class RoundedBorder implements Border {
        private int radius;
        
        RoundedBorder(int radius) {
            this.radius = radius;
        }
        
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
        }
        
        public boolean isBorderOpaque() {
            return true;
        }
        
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.setColor(Color.LIGHT_GRAY);
            g.drawRoundRect(x, y, width-1, height-1, radius, radius);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GradeCalculatorUI frame = new GradeCalculatorUI();
            frame.setVisible(true);
        });
    }
}