package ordering;

public class Menu {
    private String size;
    private int jumlah;
    private double harga;

    public Menu(String size, int jumlah) {
        super();
        this.size = size;
        this.jumlah = jumlah;
        harga=0.0;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
    @Override
    public String toString(){
        return String.format("%d ukuran %s", this.getJumlah(), this.getSize());
    }
}
