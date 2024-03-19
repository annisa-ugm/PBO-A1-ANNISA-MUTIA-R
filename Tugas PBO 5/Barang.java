public class Barang {
    private String namaBarang;
    private int hargaBarang;
    private int jumlahBarang;

    public Barang(String namaBarang, int hargaBarang, int jumlahBarang) {
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
        this.jumlahBarang = jumlahBarang;
    }

    // Getter dan Setter untuk namaBarang
    public String getNamaBarang() {
        return namaBarang;
    }
    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    // Getter dan Setter untuk hargaBarang
    public int getHargaBarang() {
        return hargaBarang;
    }
    public void setHargaBarang(int hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    // Getter dan Setter untuk jumlahBarang
    public int getJumlahBarang() {
        return jumlahBarang;
    }
    public void setJumlahBarang(int jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }
}





