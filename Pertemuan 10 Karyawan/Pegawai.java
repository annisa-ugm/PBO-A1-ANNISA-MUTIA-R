//Bagian 1
public class Pegawai extends Karyawan{
    Pegawai(String nama, String department, char jenisKelamin) {
        this.nama = nama;
        this.department = department;
        this.jenisKelamin = jenisKelamin;
    }

    //Bagian 2
    public String getJabatan() {
        return "Pegawai";
    }
    @Override
    public int hitungTHR() {
        return gaji;
    }
    //Bagian 3
    @Override
    public void setNip(String nip) {
        if (nip.startsWith("P")) {
            this.nip = nip;
        } else {
            System.out.println("Format NIP tidak sesuai untuk Pegawai.");
        }
    }
    @Override
    public void setNip(int nomorNip) {
        this.nomorNip = nomorNip;
        this.nip = "P000" + nomorNip;
    }

    //Bagian 4
    @Override
    public void setCuti(String jenisCuti) {
        this.jenisCuti = jenisCuti;
        this.cuti = hitungCuti();
    }

    //Bagian 5
    @Override
    public void displayInfo() {
        int totalTHR = hitungTHR();
        int totalCuti = hitungCuti();
        System.out.println("Jabatan : " + getJabatan() +
                "\nNama : " + nama +
                "\nDepartemen : " + department +
                "\nNIP : " + nip +
                "\nGaji : " + gaji +
                "\nTHR : " + totalTHR +
                "\nCuti : " + totalCuti);
        System.out.println("========================================");
    }
}
