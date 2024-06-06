import java.util.Objects;

public class Pasien {
    private String nama;
    private String tanggalLahir;
    private orang.JENIS_KELAMIN gender;
    private String pekerjaan;
    private String alamat;

    public Pasien(String nama, String tanggalLahir, orang.JENIS_KELAMIN gender, String pekerjaan, String alamat) {
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.gender = gender;
        this.pekerjaan = pekerjaan;
        this.alamat = alamat;
    }
    public String getNama() {
        return nama;
    }

    public void daftar(RumahSakit rumahSakit, String keluhan, String namaDokter, Antrian.tipePasiens tipePasien) {
        Dokter dokter = rumahSakit.cariDokter(namaDokter);
        if (dokter == null) {
            System.out.println("DOKTER TERSEBUT TIDAK TERSEDIA");
        } else {
            Antrian antrian = rumahSakit.cariAntrian(dokter);
            if (antrian.pasienTerdaftar(this)) {
                System.out.println("PASIEN SUDAH TERDAFTAR");
            } else {
                antrian.tambahPasien(this);
                System.out.println("SUKSES");
            }
        }
    }

    public void periksa(RumahSakit rumahSakit) {
        Dokter dokter = rumahSakit.cariDokterYangMemilikiPasien(this);
        if (dokter == null) {
            System.out.println("BELUM DAFTAR");
            return;
        }

        Antrian antrian = rumahSakit.cariAntrian(dokter);
        Pasien pasienTeratas = antrian.getPasienTeratas();

        if (pasienTeratas.equals(this)) {
            antrian.hapusPasien(this);
            System.out.println("SUKSES");
        } else {
            System.out.println("BELUM SAATNYA PERIKSA");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pasien pasien = (Pasien) o;
        return Objects.equals(nama, pasien.nama) &&
                Objects.equals(tanggalLahir, pasien.tanggalLahir);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nama, tanggalLahir);
    }
}


