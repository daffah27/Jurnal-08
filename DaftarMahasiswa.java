/*
 * Nilai Mahasiswa pada saat pembuatan awal bernilai Null atau kosong
 * 
 */


import java.util.*;

public class DaftarMahasiswa {
    public static void main(String[] args) {
        Map<String, Mahasiswa> dataMahasiswa = new HashMap<>();

        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("--- Program Daftar Mahasiswa ---");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("3. Simpan Nilai Mahasiswa");
            System.out.println("4. Tampilkan Data Mahasiswa");
            System.out.println("5. Tampilkan Rata-rata Nilai");
            System.out.println("6. Keluar");
            System.out.print("Masukkan pilihan Anda: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:    
                    System.out.print("Masukkan NIM: ");
                    String nim = input.nextLine();

                    System.out.print("Masukkan Nama: ");
                    String nama = input.nextLine();
                    
                    System.out.print("Masukkan Kelas: ");
                    String kelas = input.nextLine();
                    
                    tambahMahasiswa(dataMahasiswa, nim, nama, kelas, null);
                    break;
    
                case 2:
                    System.out.print("Masukkan NIM mahasiswa yang akan dihapus: ");
                    String nimHapus = input.nextLine();
                    hapusMahasiswa(dataMahasiswa, nimHapus);
                    break;
    
                case 3:
                    System.out.print("Masukkan NIM mahasiswa: ");
                    String nimSimpan = input.nextLine();
                    System.out.print("Masukkan nilai mahasiswa: ");
                    Double nilaiSimpan = input.nextDouble();
                    simpanNilaiMahasiswa(dataMahasiswa, nimSimpan, nilaiSimpan);
                    break;
                
                case 4:
                    tampilkanDataMahasiswa(dataMahasiswa);
                    break;
                
                case 5:
                    tampilkanRataRataNilai(dataMahasiswa);
                    break;
    
                case 6:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        } while (pilihan != 6);
    }

    public static void tambahMahasiswa(Map<String, Mahasiswa> dataMahasiswa, String nim, String nama, String kelas, Double nilai) {
        Mahasiswa mahasiswa = new Mahasiswa(nim, nama, kelas, nilai);
        dataMahasiswa.put(nim, mahasiswa);
        System.out.println("Mahasiswa dengan NIM " + nim + " telah ditambahkan.");
        System.out.println();
    }

    public static void hapusMahasiswa(Map<String, Mahasiswa> dataMahasiswa, String nim) {
        Mahasiswa mahasiswa = dataMahasiswa.get(nim);
        if(mahasiswa != null){
            dataMahasiswa.remove(nim);
            System.out.println("Mahasiswa dengan NIM " + nim + " telah dihapus.");
        } else {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        }
        System.out.println();
    }

    public static void simpanNilaiMahasiswa(Map<String, Mahasiswa> dataMahasiswa, String nim, Double nilai) {
        Mahasiswa mahasiswa = dataMahasiswa.get(nim);
        
        if (mahasiswa != null) {
            mahasiswa = new Mahasiswa(nim, mahasiswa.getNama(), mahasiswa.getKelas(), nilai);
            dataMahasiswa.put(nim, mahasiswa);
            System.out.println("Nilai mahasiswa dengan NIM " + nim + " telah disimpan.");
        } else {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        }
        System.out.println();
    }

    public static void tampilkanDataMahasiswa(Map<String, Mahasiswa> dataMahasiswa) {
        System.out.println("Data Mahasiswa:");
        for (Mahasiswa mahasiswa : dataMahasiswa.values()) {
            System.out.println("- NIM: " + mahasiswa.getNim() + ", Nama: " + mahasiswa.getNama() + ", Kelas: " + mahasiswa.getKelas() + ", Nilai: " + mahasiswa.getNilai());
        }
        System.out.println();
    }

    public static void tampilkanRataRataNilai(Map<String, Mahasiswa> dataMahasiswa) {
        Double totalNilai = 0.00;
        int jumlahMahasiswa = dataMahasiswa.size();
        for (Mahasiswa mahasiswa : dataMahasiswa.values()) {
            totalNilai += mahasiswa.getNilai();
        }
        Double rataRata = totalNilai / jumlahMahasiswa;
        System.out.println("Rata-rata nilai mahasiswa: " + rataRata);
        System.out.println();
    }
}
