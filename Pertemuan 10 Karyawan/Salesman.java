//Bagian 1
public class Salesman extends Karyawan{
    private int target;
    private int penjualan;

    //Bagian 2
    Salesman(String nama, String department, char jenisKelamin) {
        this.nama = nama;
        this.department = department;
        this.jenisKelamin = jenisKelamin;
    }

    //Bagian 3
    public String getJabatan() {
        return "Salesman";
    }
    @Override
    public int hitungTHR() {
        if (penjualan >= target) {
            return gaji * 2;
        } else {
            return gaji;
        }
    }

    //Bagian 4
    public void setTarget(int target) {
        this.target = target;
    }
    public void setPenjualan(int penjualan) {
        this.penjualan = penjualan;
    }

    //Bagian 5
    @Override
    public void setNip(String nip) {
        if (nip.startsWith("S")) {
            this.nip = nip;
        } else {
            System.out.println("Format NIP tidak sesuai untuk Salesman.");
        }
    }
    @Override
    public void setNip(int nomorNip) {
        this.nomorNip = nomorNip;
        this.nip = "S000" + nomorNip;
    }

    //Bagian 6
    @Override
    public void setCuti(String jenisCuti) {
        this.jenisCuti = jenisCuti;
        this.cuti = hitungCuti();
    }

    //Bagian 7
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
