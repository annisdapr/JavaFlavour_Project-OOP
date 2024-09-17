package ordering;

import main.Label;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Juice extends Menu {
    private String buah;
    private final List<String> listBuah;

    public Juice(String size, int jumlah, Label lbl) {
        super(size, jumlah);

        // Inisialisasi ArrayList dan tambahkan buah-buahan
        listBuah = new ArrayList<>();
        listBuah.add("Alpukat");
        listBuah.add("Mangga");
        listBuah.add("Naga");

        try {
            buah = (String) JOptionPane.showInputDialog(lbl, "Pilih Buah", "Buah Tersedia",
                    JOptionPane.QUESTION_MESSAGE, null, listBuah.toArray(), listBuah.get(0));

            // Ubah harga berdasarkan buah yang dipilih
            if (buah.equals("Mangga"))
                setHarga(7.0 * 1.25);
            else if (buah.equals("Alpukat"))
                setHarga(7.0 * 1.5);
            else setHarga(7.0 * 2.0);

        } catch (NullPointerException e) {
            // Handle jika pengguna membatalkan input
        }
    }

    // Tambahkan metode getBuah() untuk mendapatkan nilai buah
    public String getBuah() {
        return buah;
    }

    @Override
    public String toString() {
        return super.toString() + " Juice " + (buah != null ? buah : "dibatalkan");
    }
}
