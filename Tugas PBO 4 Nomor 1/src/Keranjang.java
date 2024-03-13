import java.util.ArrayList;
public class Keranjang {
    public ArrayList<Barang> isiKeranjang;
    private int totalHarga;
    private int jumlahBarang;

    public Keranjang() {
        this.isiKeranjang = new ArrayList<>();
        this.totalHarga = 0;
        this.jumlahBarang = 0;
    }

    public boolean tambahBarang(Barang barang) {
        jumlahBarang += barang.getJumlah();
        if (jumlahBarang > 5) {
            System.out.println("Wes too, Keranjange wes mbludhag!");
            return false;
        } else {
            isiKeranjang.add(barang);
            totalHarga += barang.getHarga() * barang.getJumlah();
            System.out.println("Berhasil memasukkan ke keranjang");
            return true;
        }
    }

    public void printHasil() {
        System.out.println("Jumlah Barang Di Keranjang Saat Ini: " + Math.min(jumlahBarang, 5));
        System.out.println("Barang Pada Keranjang:");
        int totalBarangCetak = 0;
        for (Barang barang : isiKeranjang) {
            if (totalBarangCetak < 5) {
                System.out.println("# " + barang.getNama() + ", jumlah : " + barang.getJumlah());
                totalBarangCetak += barang.getJumlah();
            } else {
                break;
            }
        }
        System.out.println("Total Harga Yang Harus di Bayar: " + totalHarga);
    }
}
