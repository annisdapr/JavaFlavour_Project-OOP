package main;
import ordering.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.io.Serial;

public class Label extends JFrame implements ActionListener {
    @Serial
    private static final long serialVersionUID = 1L;
    private JLabel lblSize, lblMenu, lblGlass, lblPesanan;
    private JComboBox<String> size;
    private JRadioButton rdJuice, rdEskrim, rdTeh, rdKopi;
    private ButtonGroup btnGroup;
    private JTextField tfJumlah;
    private JButton btnTambah, btnPesan;
    private final ArrayList<Menu> listMenu = new ArrayList<>();

    public Label() {
        setLayout(null);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setTitle("JavaFlavour");
        init();
        btnTambah.addActionListener(this);
        btnPesan.addActionListener(this);
        setVisible(true);
    }

    public void init() {
        lblSize = new JLabel("Size:");
        lblSize.setSize(250, 50);
        lblSize.setLocation(100, 10);
        add(lblSize);

        String[] sizes = {"Small", "Regular", "Large"};
        size = new JComboBox<>(sizes);
        size.setSelectedIndex(0);
        size.setSize(100, 25);
        size.setLocation(100, 50);
        add(size);

        lblMenu = new JLabel("Pilih Menu:");
        lblMenu.setSize(500, 50);
        lblMenu.setLocation(100, 75);
        add(lblMenu);

        btnGroup = new ButtonGroup();

        rdJuice = new JRadioButton("Juice");
        rdJuice.setSize(75, 50);
        rdJuice.setLocation(100, 110);
        add(rdJuice);

        rdEskrim = new JRadioButton("Eskrim");
        rdEskrim.setSize(75, 50);
        rdEskrim.setLocation(175, 110);
        add(rdEskrim);

        rdTeh = new JRadioButton("Teh");
        rdTeh.setSize(75, 50);
        rdTeh.setLocation(250, 110);
        add(rdTeh);

        rdKopi = new JRadioButton("Kopi");
        rdKopi.setSize(75, 50);
        rdKopi.setLocation(325, 110);
        add(rdKopi);

        btnGroup.add(rdJuice);
        btnGroup.add(rdEskrim);
        btnGroup.add(rdTeh);
        btnGroup.add(rdKopi);

        lblGlass = new JLabel("Jumlah Pesanan:");
        lblGlass.setSize(500, 50);
        lblGlass.setLocation(100, 145);
        add(lblGlass);

        tfJumlah = new JTextField();
        tfJumlah.setSize(300, 25);
        tfJumlah.setLocation(100, 185);
        add(tfJumlah);

        btnTambah = new JButton("Tambah");
        btnTambah.setSize(120, 40);
        btnTambah.setLocation(100, 230);
        add(btnTambah);

        btnPesan = new JButton("Pesan");
        btnPesan.setSize(120, 40);
        btnPesan.setLocation(280, 230);
        btnPesan.setEnabled(false);
        add(btnPesan);

        lblPesanan = new JLabel();
        lblPesanan.setSize(500, 50);
        lblPesanan.setLocation(100, 270);
        add(lblPesanan);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String size_of = (String) size.getSelectedItem();
        if (e.getSource().equals(btnTambah)) {
            if ((rdJuice.isSelected() || rdTeh.isSelected() || rdKopi.isSelected() || rdEskrim.isSelected())
                    && !tfJumlah.getText().isEmpty()) {
                try {
                    int jumPesanan = Integer.parseInt(tfJumlah.getText().trim());
                    Menu menu;
                    if (rdJuice.isSelected()) {
                        menu = new Juice(size_of, jumPesanan, this);
                    } else if (rdEskrim.isSelected()) {
                        menu = new Eskrim(size_of, jumPesanan, this);
                    } else if (rdTeh.isSelected()) {
                        menu = new Teh(size_of, jumPesanan, this);
                    } else {
                        menu = new Kopi(size_of, jumPesanan, this);
                    }
                    tfJumlah.setText(null);

                    if (menu instanceof Eskrim && ((Eskrim) menu).getRasa() == null) {
                        JOptionPane.showMessageDialog(this, "Pemilihan dibatalkan");
                    } else if (menu instanceof Juice && ((Juice) menu).getBuah() == null) {
                        JOptionPane.showMessageDialog(this, "Pemilihan dibatalkan");
                    } else {
                        listMenu.add(menu);
                        lblPesanan.setText(menu + " ditambahkan");
                        btnGroup.clearSelection();
                        btnPesan.setEnabled(true);
                    }
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(this, "Jumlah pesanan tidak valid, silakan masukkan angka");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Pilih jenis menu dan masukkan jumlah pesanan");
            }
        }
        if (e.getSource().equals(btnPesan)) {
            StringBuilder pesanan = new StringBuilder();
            double bayar = 0.0;
            for (Menu menuPesan : listMenu) {
                pesanan.append(menuPesan)
                        .append(" - Rp.")
                        .append(menuPesan.getJumlah() * menuPesan.getHarga())
                        .append("\n");
                bayar += menuPesan.getJumlah() * menuPesan.getHarga();
            }
            JOptionPane.showMessageDialog(this, pesanan.toString());
            JOptionPane.showMessageDialog(this, "Subtotal: Rp." + bayar);
            lblPesanan.setText(null);
            btnPesan.setEnabled(false);
            listMenu.clear();
        }
    }

    public static void main(String[] args) {
        new Label();
    }
}
