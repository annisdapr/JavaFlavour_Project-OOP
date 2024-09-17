package ordering;

import main.Label;

import javax.swing.*;

public class Kopi extends Menu {
    private final boolean susu;

    public Kopi(String size, int jumlah, Label lbl) {
        super(size, jumlah);
        // Simplified if statement using ternary operator
        susu = (JOptionPane.showConfirmDialog(lbl, "Tambah susu?", "Susu", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);

        double harga;
        if (size.equals("Small")) harga = 3.5;
        else if (size.equals("Regular")) harga = 5.0;
        else harga = 6.5;

        if (susu) harga *= 1.5;
        setHarga(harga);
    }

    @Override
    public String toString() {
        if (susu) return super.toString() + " Kopi dengan susu";
        else return super.toString() + " Kopi";
    }
}
