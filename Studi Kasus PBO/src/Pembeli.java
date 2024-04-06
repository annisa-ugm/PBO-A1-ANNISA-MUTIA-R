class Pembeli {
    private String nama;
    private Toko.TipeBarang barangDibeli;
    private int jumlahBarang;

    public Pembeli(String nama, Toko.TipeBarang barangDibeli, int jumlahBarang) {
        this.nama = nama;
        this.barangDibeli = barangDibeli;
        this.jumlahBarang = jumlahBarang;
    }

    public String getNama() {
        return nama;
    }
    public Toko.TipeBarang getBarangDibeli() {
        return barangDibeli;
    }
    public int getJumlahBarang() {
        return jumlahBarang;
    }

}