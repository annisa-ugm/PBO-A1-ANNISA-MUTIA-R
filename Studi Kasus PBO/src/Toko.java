import java.util.ArrayList;
import java.util.List;
class Toko {
    public enum TipeBarang {
        MEJA, KURSI, LEMARI
    }

    private List<Pembeli> antrian = new ArrayList<>();
    private Gudang gudangBarang;

    public Toko() {
        gudangBarang = new Gudang();
    }
    public Gudang getGudangBarang() {
        return gudangBarang;
    }

    public void tambahAntrian(Pembeli pembeli) {
        antrian.add(pembeli);
        System.out.println("berhasil menambah antrian");
    }

    public void selesaikanAntrian() {
        if (!antrian.isEmpty()) {
            Pembeli pembeli = antrian.get(0);
            TipeBarang tipeBarang = pembeli.getBarangDibeli();
            int jumlahBarang = pembeli.getJumlahBarang();
            int currentStock = gudangBarang.getstokBahan().get(tipeBarang);
            if (currentStock >= jumlahBarang) {
                gudangBarang.keluarkanBarangDariGudang(tipeBarang, jumlahBarang);
                System.out.println("antrian terdepan berhasil di selesaikan");
                antrian.remove(0);
            }
            else {
                System.out.println("Kondisi tidak terpenuhi untuk memenuhi permintaan pembeli.");
            }
        }
    }

    public void cekIsiAntrian() {
        System.out.println("\nLIST ANTRIAN :");
        for (int i = 0; i < antrian.size(); i++) {
            Pembeli pembeli = antrian.get(i);
            System.out.println("antrian ke " + (i + 1) + ", nama : " +
                    pembeli.getNama() + ", barang di beli " + pembeli.getBarangDibeli() +
                    ", jumlah barang di beli : " + pembeli.getJumlahBarang());
        }
    }

    public boolean antrianPenuh() {
        return antrian.size() >= 20;
    }
    public boolean barangDibeliTersedia(TipeBarang tipeBarang, int jumlah) {
        return gudangBarang.getstokBahan().get(tipeBarang) >= jumlah;
    }

}