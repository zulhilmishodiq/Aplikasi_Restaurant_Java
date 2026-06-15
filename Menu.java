/*
 * Class Menu
 * Digunakan untuk merepresentasikan data menu restoran
 */
public class Menu {

    // Atribut menu
    String nama;
    int harga;
    String kategori;

    /*
     * Constructor
     * Digunakan untuk mengisi data menu saat object dibuat
     */
    public Menu(String nama, int harga, String kategori) {
        this.nama = nama;
        this.harga = harga;
        this.kategori = kategori;
    }
}