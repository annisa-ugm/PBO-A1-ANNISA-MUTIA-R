//Bagian 1
public class Karyawan {
    int thr;
    protected int cuti;
    protected String jenisCuti;
    protected String nip;
    protected int nomorNip;
    protected int gaji;
    protected String jabatan;
    String nama;
    String department;
    char jenisKelamin;

    //Bagian 2
    public int getCuti() {
        return cuti;
    }
    public void setCuti(int cuti) {
        this.cuti = cuti;
    }
    public void setCuti(String jenisCuti) {
        this.jenisCuti = jenisCuti;
    }

    //Bagian 3
    public String getNip() {
        return nip;
    }
    public void setNip(String nip) {
        this.nip = nip;
    }
    public void setNip(int nip) {
        this.nomorNip = nip;
    }

    //Bagian 4
    public int getGaji() {
        return gaji;
    }
    public void setGaji(int gaji) {
        this.gaji = gaji;
    }

    //Bagian 5
    public int hitungTHR() {
        return gaji;
    }

    //Bagian 6
    public int hitungCuti() {
        int cutiNormal = 12;
        int cutiTambahan = 0;
        if (jenisCuti != null && !jenisCuti.isEmpty()) {
            if (jenisCuti.equalsIgnoreCase("pernikahan")) {
                cutiTambahan = 2;
            } else if (jenisCuti.equalsIgnoreCase("persalinan")) {
                cutiTambahan = (jenisKelamin == 'P') ? 90 : 3;
            }
        } else {
            cutiTambahan = getCuti();
        }
        return cutiNormal + cutiTambahan;
    }
    //Bagian 7
    public void displayInfo() {
        int totalTHR = hitungTHR();
        int totalCuti = hitungCuti();
        System.out.println("Jabatan : " + jabatan +
                "\nNama : " + nama +
                "\nDepartemen : " + department +
                "\nNIP : " + nip +
                "\nGaji : " + gaji +
                "\nTHR : " + totalTHR +
                "\nCuti : " + totalCuti);
        System.out.println("========================================");
    }

}