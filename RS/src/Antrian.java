import java.util.ArrayList;
import java.util.List;

public class Antrian {
    public enum tipePasiens {
        MANDIRI, BPJS, ASURANSI
    }

    private List<Pasien> antrianPasien;
    Dokter dokter;
    private tipePasiens tipePasien;

    public Antrian(Dokter dokter, tipePasiens tipePasien) {
        this.antrianPasien = new ArrayList<>();
        this.dokter = dokter;
        this.tipePasien = tipePasien;
    }

    public void tambahPasien(Pasien pasien) {
        antrianPasien.add(pasien);
    }

    public boolean pasienTerdaftar(Pasien pasien) {
        return antrianPasien.contains(pasien);
    }

    public Pasien getPasienTeratas() {
        if (antrianPasien.isEmpty()) {
            return null;
        }
        return antrianPasien.get(0);
    }

    public void hapusPasien(Pasien pasien) {
        antrianPasien.remove(pasien);
    }

    public void cekAntrian(int nomorDokter) {
        System.out.println("DR. " + dokter.getNama());
        if (antrianPasien.isEmpty()) {
            System.out.println("ANTRIAN KOSONG");
        } else {
            int nomorAntrian = 1;
            for (Pasien pasien : antrianPasien) {
                String idAntrian = String.format("D_%s_%d_%d", dokter.getSpesialis().toUpperCase().replace(" ", "_"), nomorDokter, nomorAntrian);
                System.out.println("ID ANTRIAN: " + idAntrian + ", Atas nama : " + pasien.getNama());
                nomorAntrian++;
            }
        }
        System.out.println("==============");
    }
}

