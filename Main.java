import java.util.Scanner;

public class Main {

    // Scanner untuk menerima input dari keyboard
    static Scanner input = new Scanner(System.in);

    // Array untuk menyimpan daftar menu restoran
    static Menu[] daftarMenu = new Menu[100];

    // Menyimpan jumlah menu yang aktif
    static int jumlahMenu = 8;

    // Array untuk menyimpan pesanan pelanggan
    static int[] pesananMenu = new int[100];
    static int[] pesananJumlah = new int[100];

    // Menyimpan jumlah pesanan yang masuk
    static int jumlahPesanan = 0;

    public static void main(String[] args) {

        // TAMPILAN DATA AWAL MENU RESTORAN

        daftarMenu[0] = new Menu("Nasi Goreng", 25000, "Makanan");
        daftarMenu[1] = new Menu("Mie Ayam", 20000, "Makanan");
        daftarMenu[2] = new Menu("Ayam Bakar", 35000, "Makanan");
        daftarMenu[3] = new Menu("Nasi Padang", 30000, "Makanan");

        daftarMenu[4] = new Menu("Es Teh", 5000, "Minuman");
        daftarMenu[5] = new Menu("Jus Alpukat", 15000, "Minuman");
        daftarMenu[6] = new Menu("Kopi", 10000, "Minuman");
        daftarMenu[7] = new Menu("Air Mineral", 7000, "Minuman");

        int pilihan;

        // MENU UTAMA PROGRAM
        // Menggunakan DO-WHILE
        do {

            System.out.println("\n==============================");
            System.out.println("      APLIKASI RESTORAN");
            System.out.println("==============================");
            System.out.println("1. Menu Pelanggan");
            System.out.println("2. Pengelolaan Menu");
            System.out.println("0. Keluar");

            System.out.print("Pilih Menu : ");
            pilihan = input.nextInt();

            // SWITCH CASE
            switch (pilihan) {

                case 1:
                    menuPelanggan();
                    break;

                case 2:
                    menuPengelolaan();
                    break;

                case 0:
                    System.out.println("Terima kasih telah menggunakan program.");
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia.");
            }

        } while (pilihan != 0);
    }

    
    // Method untuk menampilkan menu pelanggan
    // Pelanggan dapat memesan beberapa menu sekaligus 
    static void menuPelanggan() {

        jumlahPesanan = 0;

        int nomorMenu;

        // WHILE / DO-WHILE untuk input pesanan berulang
        do {

            tampilMenu();

            System.out.println("0. Selesai");

            System.out.print("Pilih Nomor Menu : ");
            nomorMenu = input.nextInt();

            // Jika memilih 0 maka selesai pesan
            if (nomorMenu == 0) {
                break;
            }

            // Validasi nomor menu
            if (nomorMenu >= 1 && nomorMenu <= jumlahMenu) {

                System.out.print("Jumlah Pesanan : ");
                int jumlah = input.nextInt();

                // Menyimpan pesanan ke array
                pesananMenu[jumlahPesanan] = nomorMenu - 1;
                pesananJumlah[jumlahPesanan] = jumlah;

                jumlahPesanan++;

                System.out.println("Pesanan berhasil ditambahkan.");

            } else {

                System.out.println("Nomor menu tidak tersedia.");

            }

        } while (true);

        // Cetak struk setelah selesai pesan
        cetakStruk();
    }

     // Method menampilkan menu restoran dan dikelompokkan berdasarkan kategori
    static void tampilMenu() {

        System.out.println("\n========== MENU MAKANAN ==========");

        // FOR LOOP
        for (int i = 0; i < jumlahMenu; i++) {

            if (daftarMenu[i].kategori.equalsIgnoreCase("Makanan")) {

                System.out.println(
                        (i + 1) + ". "
                                + daftarMenu[i].nama
                                + " - Rp "
                                + daftarMenu[i].harga
                );
            }
        }

        System.out.println("\n========== MENU MINUMAN ==========");

        // FOR LOOP
        for (int i = 0; i < jumlahMenu; i++) {

            if (daftarMenu[i].kategori.equalsIgnoreCase("Minuman")) {

                System.out.println(
                        (i + 1) + ". "
                                + daftarMenu[i].nama
                                + " - Rp "
                                + daftarMenu[i].harga
                );
            }
        }
    }


     // Method untuk menghitung total pembayaran dan mencetak struk
    static void cetakStruk() {

        int subtotal = 0;

        // Nilai promo minuman gratis
        int promoMinuman = 0;

        System.out.println("\n=================================");
        System.out.println("          STRUK PEMBAYARAN");
        System.out.println("=================================");

        // Menghitung seluruh item pesanan
        for (int i = 0; i < jumlahPesanan; i++) {

            Menu menu = daftarMenu[pesananMenu[i]];

            int totalItem =
                    menu.harga * pesananJumlah[i];

            subtotal += totalItem;

            System.out.println(
                    menu.nama
                            + " x "
                            + pesananJumlah[i]
                            + " = Rp "
                            + totalItem
            );

            
             // Promo beli 1 gratis 1 minuman dengan Nested If
            if (subtotal > 50000) {

                if (menu.kategori.equalsIgnoreCase("Minuman")) {

                    if (pesananJumlah[i] >= 2) {

                        promoMinuman += menu.harga;

                    }
                }
            }
        }

        // Diskon 10%
        double diskon;

        if (subtotal > 100000) {

            diskon = subtotal * 0.10;

        } else {

            diskon = 0;

        }

        // Pajak 10%
        double pajak =
                (subtotal - diskon) * 0.10;

        // Biaya pelayanan
        int service = 20000;

        // Total akhir
        double totalBayar =
                subtotal
                        - diskon
                        - promoMinuman
                        + pajak
                        + service;

        System.out.println("---------------------------------");
        System.out.println("Subtotal          : Rp " + subtotal);
        System.out.println("Diskon 10%        : Rp " + diskon);
        System.out.println("Promo Minuman     : Rp " + promoMinuman);
        System.out.println("Pajak 10%         : Rp " + pajak);
        System.out.println("Biaya Pelayanan   : Rp " + service);
        System.out.println("---------------------------------");
        System.out.println("TOTAL BAYAR       : Rp " + totalBayar);
        System.out.println("=================================");
    }

    // Menu untuk pemilik restoran
    static void menuPengelolaan() {

        int pilihan;

        do {

            System.out.println("\n===== PENGELOLAAN MENU =====");
            System.out.println("1. Tambah Menu");
            System.out.println("2. Ubah Harga Menu");
            System.out.println("3. Hapus Menu");
            System.out.println("0. Kembali");

            System.out.print("Pilih : ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {

                case 1:
                    tambahMenu();
                    break;

                case 2:
                    ubahHarga();
                    break;

                case 3:
                    hapusMenu();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia.");
            }

        } while (pilihan != 0);
    }

    // Menambahkan menu baru
    static void tambahMenu() {

        String lagi;

        do {

            System.out.print("Nama Menu : ");
            String nama = input.nextLine();

            System.out.print("Harga Menu : ");
            int harga = input.nextInt();
            input.nextLine();

            System.out.print("Kategori (Makanan/Minuman) : ");
            String kategori = input.nextLine();

            daftarMenu[jumlahMenu] =
                    new Menu(nama, harga, kategori);

            jumlahMenu++;

            System.out.println("Menu berhasil ditambahkan.");

            System.out.print("Tambah lagi? (Ya/Tidak) : ");
            lagi = input.nextLine();

        } while (lagi.equalsIgnoreCase("Ya"));
    }

    // Mengubah harga menu
    static void ubahHarga() {

        tampilMenu();

        System.out.print("Pilih Nomor Menu : ");
        int nomor = input.nextInt();

        if (nomor >= 1 && nomor <= jumlahMenu) {

            input.nextLine();

            System.out.print("Yakin ubah harga? (Ya/Tidak) : ");
            String konfirmasi = input.nextLine();

            if (konfirmasi.equalsIgnoreCase("Ya")) {

                System.out.print("Harga Baru : ");
                int hargaBaru = input.nextInt();

                daftarMenu[nomor - 1].harga = hargaBaru;

                System.out.println("Harga berhasil diubah.");
            }

        } else {

            System.out.println("Nomor menu tidak tersedia.");

        }
    }

    // Menghapus menu
    static void hapusMenu() {

        tampilMenu();

        System.out.print("Pilih Nomor Menu : ");
        int nomor = input.nextInt();

        if (nomor >= 1 && nomor <= jumlahMenu) {

            input.nextLine();

            System.out.print("Yakin hapus? (Ya/Tidak) : ");
            String konfirmasi = input.nextLine();

            if (konfirmasi.equalsIgnoreCase("Ya")) {

                // Menggeser data array ke kiri
                for (int i = nomor - 1; i < jumlahMenu - 1; i++) {

                    daftarMenu[i] = daftarMenu[i + 1];

                }

                jumlahMenu--;

                System.out.println("Menu berhasil dihapus.");
            }

        } else {

            System.out.println("Nomor menu tidak tersedia.");

        }
    }
}