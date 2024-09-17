package ordering;

import main.Label;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Eskrim extends Menu {
    private String rasa;
    private final List<String> listRasa;

    public Eskrim(String size, int amount, Label lbl) {
        super(size, amount);

        // Inisialisasi ArrayList dan tambahkan rasa eskrim
        listRasa= new ArrayList<>();
        listRasa.add("Coklat");
        listRasa.add("Vanila");
        listRasa.add("Strawberry");

        try {
            rasa = (String) JOptionPane.showInputDialog(lbl, "Pilih rasa", "Pilihan Rasa Eskrim",
                    JOptionPane.QUESTION_MESSAGE, null, listRasa.toArray(), listRasa.get(0));

            // Cek apakah pemilihan rasa dibatalkan
            if (rasa == null) {
                // Set rasa menjadi null untuk menandakan pembatalan
                rasa = null;
            }

            double harga;
            if (size.equals("Small"))
                harga = 5.0;
            else if (size.equals("Regular"))
                harga = 7.0;
            else
                harga = 9.0;

            setHarga(harga);
        } catch (NullPointerException e) {
            // Handle jika pengguna membatalkan input
        }
    }

    // Tambahkan metode getRasa() untuk mendapatkan nilai rasa
    public String getRasa() {
        return rasa;
    }

    @Override
    public String toString() {
        return super.toString() +" Eskrim "+ (rasa != null ? rasa : "dibatalkan");
    }
}