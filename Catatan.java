/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplikasicatatan;

/**
 *
 * @author Anamaya Santi
 */
public class Catatan {
    private String judul;
    private String isi;

    // Constructor
    public Catatan(String judul, String isi) {
        this.judul = judul;
        this.isi = isi;
    }

    // Getter dan Setter
    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    // Overriding method toString untuk menampilkan catatan
    @Override
    public String toString() {
        return "Judul: " + judul + "\nIsi: " + isi;
    }
}
