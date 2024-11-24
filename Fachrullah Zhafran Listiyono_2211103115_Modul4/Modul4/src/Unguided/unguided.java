package Unguided;

/**
 *
 * @author Fachrullah Zhafran Listiyono_2211103115
 */

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Fachrullah Zhafran 
 * Nim 2211103115
 */
public class unguided {
    public static void main(String[] args) {
        // Membuat Frame
        JFrame frame = new JFrame("Form Registrasi Pelayanan Kesehatan Puskesmas");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Judul Form
        JLabel labelJudul = new JLabel("FORM REGISTRASI PUSKESMAS", JLabel.CENTER);
        labelJudul.setFont(new Font("Arial", Font.BOLD, 16));
        labelJudul.setBounds(50, 20, 300, 30);
        frame.add(labelJudul);

        // Label dan Input Nama
        JLabel labelNama = new JLabel("Nama Lengkap:");
        labelNama.setBounds(30, 70, 100, 20);
        frame.add(labelNama);

        JTextField fieldNama = new JTextField();
        fieldNama.setBounds(150, 70, 200, 25);
        frame.add(fieldNama);

        // Label dan Input NIM
        JLabel labelNIM = new JLabel("UMUR:");
        labelNIM.setBounds(30, 110, 100, 20);
        frame.add(labelNIM);

        JTextField fieldNIM = new JTextField();
        fieldNIM.setBounds(150, 110, 200, 25);
        frame.add(fieldNIM);

        // Label dan ComboBox Program Studi
        JLabel labelProdi = new JLabel("Jenis Poli:");
        labelProdi.setBounds(30, 150, 100, 20);
        frame.add(labelProdi);

        String[] prodi = {"Poli Gigi", "Poli Anak", "Poli Batuk", "Poli Lansia"};
        JComboBox<String> comboProdi = new JComboBox<>(prodi);
        comboProdi.setBounds(150, 150, 200, 25);
        frame.add(comboProdi);

        // Label dan RadioButton Jenis Kelamin
        JLabel labelJK = new JLabel("Jenis Kelamin:");
        labelJK.setBounds(30, 190, 100, 20);
        frame.add(labelJK);

        JRadioButton radioLaki = new JRadioButton("Laki-Laki");
        radioLaki.setBounds(150, 190, 100, 25);
        JRadioButton radioPerempuan = new JRadioButton("Perempuan");
        radioPerempuan.setBounds(250, 190, 100, 25);

        ButtonGroup groupJK = new ButtonGroup();
        groupJK.add(radioLaki);
        groupJK.add(radioPerempuan);

        frame.add(radioLaki);
        frame.add(radioPerempuan);

        // Label dan TextArea Alamat
        JLabel labelAlamat = new JLabel("Alamat:");
        labelAlamat.setBounds(30, 230, 100, 20);
        frame.add(labelAlamat);

        JTextArea textAlamat = new JTextArea();
        textAlamat.setBounds(150, 230, 200, 60);
        textAlamat.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        frame.add(textAlamat);

        // Tombol Simpan dan Batal
        JButton btnSimpan = new JButton("SIMPAN");
        btnSimpan.setBounds(100, 320, 100, 30);
        btnSimpan.setBackground(Color.BLUE);
        btnSimpan.setForeground(Color.WHITE);

        JButton btnBatal = new JButton("BATAL");
        btnBatal.setBounds(210, 320, 100, 30);
        btnBatal.setBackground(Color.BLUE);
        btnBatal.setForeground(Color.WHITE);

        frame.add(btnSimpan);
        frame.add(btnBatal);

        // Menampilkan Frame
        frame.setVisible(true);
    }
}
