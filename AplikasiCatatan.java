/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aplikasicatatan;

import java.util.Scanner;
/**
 *
 * @author Anamaya Santi
 */
public class AplikasiCatatan {
    private static final int KAPASITAS_MAX = 100;
    private Catatan[] catatanArray = new Catatan[KAPASITAS_MAX];
    private int jumlahCatatan = 0;

    // Method untuk menambah catatan
    public void tambahCatatan(String judul, String isi) {
        if (jumlahCatatan < KAPASITAS_MAX) {
            catatanArray[jumlahCatatan++] = new Catatan(judul, isi);
            System.out.println("Catatan berhasil ditambahkan.");
        } else {
            System.out.println("Maaf, kapasitas catatan sudah penuh.");
        }
    }

    // Method untuk menampilkan semua catatan
    public void tampilkanCatatan() {
        if (jumlahCatatan == 0) {
            System.out.println("Belum ada catatan.");
        } else {
            for (int i = 0; i < jumlahCatatan; i++) {
                System.out.println("Catatan ke-" + (i+1) + ":");
                System.out.println(catatanArray[i]);
                System.out.println();
            }
        }
    }

    // Method untuk mengubah catatan berdasarkan judul
    public void ubahCatatan(String judul, String judulBaru, String isiBaru) {
        boolean catatanDitemukan = false;
        for (int i = 0; i < jumlahCatatan; i++) {
            if (catatanArray[i].getJudul().equalsIgnoreCase(judul)) {
                catatanArray[i].setJudul(judulBaru);
                catatanArray[i].setIsi(isiBaru);
                catatanDitemukan = true;
                System.out.println("Catatan berhasil diubah.");
                break;
            }
        }
        if (!catatanDitemukan) {
            System.out.println("Catatan tidak ditemukan.");
        }
    }

    // Method untuk menghapus catatan berdasarkan judul
    public void hapusCatatan(String judul) {
        boolean catatanDitemukan = false;
        for (int i = 0; i < jumlahCatatan; i++) {
            if (catatanArray[i].getJudul().equalsIgnoreCase(judul)) {
                for (int j = i; j < jumlahCatatan - 1; j++) {
                    catatanArray[j] = catatanArray[j + 1];
                }
                catatanArray[jumlahCatatan - 1] = null;
                jumlahCatatan--;
                catatanDitemukan = true;
                System.out.println("Catatan berhasil dihapus.");
                break;
            }
        }
        if (!catatanDitemukan) {
            System.out.println("Catatan tidak ditemukan.");
        }
    }

    // Method untuk menampilkan menu aplikasi
    public void tampilkanMenu() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Tambah Catatan");
            System.out.println("2. Tampilkan Catatan");
            System.out.println("3. Ubah Catatan");
            System.out.println("4. Hapus Catatan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan judul catatan: ");
                    String judul = scanner.nextLine();
                    System.out.print("Masukkan isi catatan: ");
                    String isi = scanner.nextLine();
                    tambahCatatan(judul, isi);
                    break;
                case 2:
                    tampilkanCatatan();
                    break;
                case 3:
                    System.out.print("Masukkan judul catatan yang ingin diubah: ");
                    String judulLama = scanner.nextLine();
                    System.out.print("Masukkan judul baru: ");
                    String judulBaru = scanner.nextLine();
                    System.out.print("Masukkan isi baru: ");
                    String isiBaru = scanner.nextLine();
                    ubahCatatan(judulLama, judulBaru, isiBaru);
                    break;
                case 4:
                    System.out.print("Masukkan judul catatan yang ingin dihapus: ");
                    String judulHapus = scanner.nextLine();
                    hapusCatatan(judulHapus);
                    break;
                case 0:
                    System.out.println("Keluar dari aplikasi.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 0);
        scanner.close();
    }

    // Main method untuk menjalankan aplikasi
    public static void main(String[] args) {
        AplikasiCatatan aplikasi = new AplikasiCatatan();
        aplikasi.tampilkanMenu();
    }
}
