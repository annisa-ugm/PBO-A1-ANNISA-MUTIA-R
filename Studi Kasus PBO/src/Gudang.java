import java.util.*;
class Gudang {
    public enum Bahan {
        BAUT, KAYU, CAT
    }
    private Map<Bahan, Integer> isiGudang = new HashMap<>();
    private Map<Toko.TipeBarang, Integer> stokBahan = new HashMap<>();

    public void setstokBahan(Map<Toko.TipeBarang, Integer> stokBahan) {
        this.stokBahan = stokBahan;
    }
    public Map<Toko.TipeBarang, Integer> getstokBahan() {
        return stokBahan;
    }

    public Gudang() {
        isiGudang.put(Bahan.KAYU, 0);
        isiGudang.put(Bahan.BAUT, 0);
        isiGudang.put(Bahan.CAT, 0);
        stokBahan.put(Toko.TipeBarang.MEJA, 0);
        stokBahan.put(Toko.TipeBarang.KURSI, 0);
        stokBahan.put(Toko.TipeBarang.LEMARI, 0);
    }

    public void tambahBahan(Bahan bahan, int jumlah) {
        isiGudang.put(bahan, isiGudang.get(bahan) + jumlah);
    }
    public void kurangiBahan(Bahan bahan, int jumlah) {
        isiGudang.put(bahan, isiGudang.get(bahan) - jumlah);
    }

    public void buatBarang(Toko.TipeBarang tipeBarang, int jumlah) {
        if (slotTersedia(tipeBarang, jumlah) && bahanPembuatanMencukupi(tipeBarang, jumlah)) {
            switch (tipeBarang) {
                case MEJA:
                    kurangiBahan(Bahan.KAYU, jumlah * 3);
                    kurangiBahan(Bahan.BAUT, jumlah * 20);
                    kurangiBahan(Bahan.CAT, jumlah * 2);
                    break;
                case KURSI:
                    kurangiBahan(Bahan.KAYU, jumlah * 2);
                    kurangiBahan(Bahan.BAUT, jumlah * 10);
                    kurangiBahan(Bahan.CAT, jumlah);
                    break;
                case LEMARI:
                    kurangiBahan(Bahan.KAYU, jumlah * 5);
                    kurangiBahan(Bahan.BAUT, jumlah * 30);
                    kurangiBahan(Bahan.CAT, jumlah * 3);
                    break;
            }
            stokBahan.put(tipeBarang, stokBahan.get(tipeBarang) + jumlah);
            System.out.println(jumlah + " " + tipeBarang + " berhasil di tambahkan ke gudang");
        } else {
            System.out.println("bahan tidak cukup");
        }
    }

    public boolean slotTersedia(Toko.TipeBarang tipeBarang, int jumlahBarang) {
        int currentStock = stokBahan.get(tipeBarang);
        int maxStock;

        switch (tipeBarang) {
            case MEJA:
                maxStock = 10;
                break;
            case KURSI:
                maxStock = 20;
                break;
            case LEMARI:
                maxStock = 5;
                break;
            default:
                return false;
        }

        return currentStock + jumlahBarang <= maxStock;
    }


    public boolean bahanPembuatanMencukupi(Toko.TipeBarang tipeBarang, int jumlah) {
        int kayu = isiGudang.get(Bahan.KAYU);
        int baut = isiGudang.get(Bahan.BAUT);
        int cat = isiGudang.get(Bahan.CAT);

        switch (tipeBarang) {
            case MEJA:
                return kayu >= jumlah * 3 && baut >= jumlah * 20 && cat >= jumlah * 2;
            case KURSI:
                return kayu >= jumlah * 2 && baut >= jumlah * 10 && cat >= jumlah;
            case LEMARI:
                return kayu >= jumlah * 5 && baut >= jumlah * 30 && cat >= jumlah * 3;
            default:
                return false;
        }
    }

    public void cekStokBahan() {
        System.out.println("\nSTOK BAHAN :");
        for (Bahan bahan : Bahan.values()) {
            System.out.println("jumlah : " + bahan + ", saat ini adalah : "
                    + isiGudang.get(bahan) + " buah");
        }
        System.out.println(" ");
    }

    public void cekIsiGudang() {
        System.out.println("\nISI GUDANG :");
        for (Toko.TipeBarang tipeBarang : Toko.TipeBarang.values()) {
            System.out.println("jumlah : " + tipeBarang + ", saat ini adalah : "
                    + stokBahan.get(tipeBarang) + " buah");
        }
        System.out.println(" ");
    }

    public void masukanBarangKeGudang(Toko.TipeBarang tipeBarang, int jumlah) {
        stokBahan.put(tipeBarang, stokBahan.get(tipeBarang) + jumlah);
        System.out.println(jumlah + " " + tipeBarang +
                " berhasil di masukkan ke gudang");
    }

    public void keluarkanBarangDariGudang(Toko.TipeBarang tipeBarang, int jumlah) {
        int currentStock = stokBahan.get(tipeBarang);
        if (currentStock >= jumlah) {
            stokBahan.put(tipeBarang, currentStock - jumlah);
            System.out.println("\n" + jumlah + " " + tipeBarang +
                    " berhasil di keluarkan dari gudang");
        } else {
            System.out.println("Stok " + tipeBarang +
                    " tidak cukup untuk dikeluarkan");
        }
    }

}