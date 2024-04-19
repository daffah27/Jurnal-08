public class Mahasiswa {
    private String nim;
    private String nama;
    private String kelas;
    private Double nilai;

    public Mahasiswa(String nim, String nama, String kelas, Double nilai) {
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
        this.nilai = nilai;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public String getKelas() {
        return kelas;
    }

    public Double getNilai() {
        return nilai;
    }
}
