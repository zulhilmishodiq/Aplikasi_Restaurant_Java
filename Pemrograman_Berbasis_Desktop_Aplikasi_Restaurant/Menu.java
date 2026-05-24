public class Menu {
    String nama;
    String kategori;
    int harga;

    public Menu(String nama, String kategori, int harga) {
        this.nama = nama;
        this.kategori = kategori;
        this.harga = harga;
    }

    public void tampilkanMenu() {
        System.out.println(nama + " | " + kategori + " | Rp." + harga);
    }
}