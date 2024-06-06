import java.util.ArrayList;
import java.util.List;

public class RumahSakit {
    private String nama;
    private String alamat;
    private String noTelepon;
    private List<Dokter> listDokter;
    private List<Antrian> listAntrian;

    public RumahSakit(String nama, String alamat, String noTelepon) {
        this.nama = nama;
        this.alamat = alamat;
        this.noTelepon = noTelepon;
        this.listDokter = new ArrayList<>();
        this.listAntrian = new ArrayList<>();
    }

    public void tambahDokter(Dokter dokter) {
        if (listDokter.contains(dokter)) {
            System.out.println("DOKTER SUDAH TERDAFTAR");
        } else {
            listDokter.add(dokter);
            listAntrian.add(new Antrian(dokter, Antrian.tipePasiens.MANDIRI));
            System.out.println("SUKSES");
        }
    }

    public void cekListDokter() {
        if (listDokter.isEmpty()) {
            System.out.println("BELUM ADA DOKTER YANG TERSEDIA SAAT INI");
        } else {
            System.out.println("BERIKUT LIST DOKTER YANG TERSEDIA SAAT INI");
            System.out.println("===========================================");
            for (Dokter dokter : listDokter) {
                System.out.println("Nama Dokter :" + dokter.getNama() + ", Dokter spesialis : " + dokter.getSpesialis());
            }
        }
    }

    public void cekAntrianPasien() {
        System.out.println("ANTRIAN RUMAH SAKIT SAAT INI");
        System.out.println("================================");
        for (int i = 0; i < listAntrian.size(); i++) {
            listAntrian.get(i).cekAntrian(i + 1);
        }
    }

    public Dokter cariDokter(String namaDokter) {
        for (Dokter dokter : listDokter) {
            if (dokter.getNama().equalsIgnoreCase(namaDokter)) {
                return dokter;
            }
        }
        return null;
    }

    public Antrian cariAntrian(Dokter dokter) {
        for (Antrian antrian : listAntrian) {
            if (antrian.dokter.equals(dokter)) {
                return antrian;
            }
        }
        return null;
    }

    public Dokter cariDokterYangMemilikiPasien(Pasien pasien) {
        for (Antrian antrian : listAntrian) {
            if (antrian.pasienTerdaftar(pasien)) {
                return antrian.dokter;
            }
        }
        return null;
    }
}
