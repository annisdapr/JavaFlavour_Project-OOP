package ordering;
import main.Label;

import javax.swing.*;
public class Teh extends Menu {
    private final boolean gula;
    public Teh(String size, int amount, Label lbl) {
        super(size,amount);
        gula = (JOptionPane.showConfirmDialog(lbl, "Tambah gula?", "Gula", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
        double harga;
        if(size.equals("Small")) harga= 3.0;
        else if(size.equals("Regular")) harga= 4.0;
        else harga= 5.0;
        if(gula) harga*=1.25;
        setHarga(harga);
    }

    @Override
    public String toString() {
        if(gula) return super.toString()+" Teh dengan gula";
        else return super.toString() + " Teh";
    }
}
