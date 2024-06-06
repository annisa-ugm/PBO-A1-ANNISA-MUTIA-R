public class Dokter {
    private String nama;
    private String tanggalLahir;
    private orang.JENIS_KELAMIN gender;
    private String nomorSTR;
    private String spesialis;
    public Dokter(String nama, String tanggalLahir, orang.JENIS_KELAMIN gender, String nomorSTR, String spesialis) {
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.gender = gender;
        this.nomorSTR = nomorSTR;
        this.spesialis = spesialis;
    }

    public String getNama() {
        return nama;
    }
    public String getSpesialis() {
        return spesialis;
    }
    public void daftar(RumahSakit rumahSakit) {
        rumahSakit.tambahDokter(this);
    }
}


