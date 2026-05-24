import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    // ARRAY MENU
    static Menu[] daftarMenu = new Menu[100];
    static int jumlahMenu = 0;

    // ARRAY PESANAN
    static String[] pesanan = new String[100];
    static int[] jumlahPesanan = new int[100];
    static int totalPesanan = 0;

    public static void main(String[] args) {

        // DATA AWAL MENU
        tambahDataAwal();

        int pilih;

        do {
            System.out.println("\n===== APLIKASI RESTORAN =====");
            System.out.println("1. Menu Pelanggan");
            System.out.println("2. Manajemen Menu");
            System.out.println("3. Keluar");
            System.out.print("Pilih Menu : ");
            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {
                case 1:
                    menuPelanggan();
                    break;

                case 2:
                    manajemenMenu();
                    break;

                case 3:
                    System.out.println("Terima kasih.");
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia!");
            }

        } while (pilih != 3);
    }

    // TAMBAH DATA AWAL
    static void tambahDataAwal() {

        daftarMenu[jumlahMenu++] = new Menu("Nasi Goreng", "Makanan", 25000);
        daftarMenu[jumlahMenu++] = new Menu("Mie Ayam", "Makanan", 20000);
        daftarMenu[jumlahMenu++] = new Menu("Ayam Geprek", "Makanan", 30000);
        daftarMenu[jumlahMenu++] = new Menu("Sate Ayam", "Makanan", 35000);

        daftarMenu[jumlahMenu++] = new Menu("Es Teh", "Minuman", 10000);
        daftarMenu[jumlahMenu++] = new Menu("Jus Jeruk", "Minuman", 15000);
        daftarMenu[jumlahMenu++] = new Menu("Kopi", "Minuman", 12000);
        daftarMenu[jumlahMenu++] = new Menu("Milkshake", "Minuman", 20000);
    }

    // TAMPILKAN MENU
    static void tampilkanMenu() {

        System.out.println("\n===== MENU MAKANAN =====");

        for (int i = 0; i < jumlahMenu; i++) {
            if (daftarMenu[i].kategori.equalsIgnoreCase("Makanan")) {
                System.out.println((i + 1) + ". " +
                        daftarMenu[i].nama +
                        " - Rp." +
                        daftarMenu[i].harga);
            }
        }

        System.out.println("\n===== MENU MINUMAN =====");

        for (int i = 0; i < jumlahMenu; i++) {
            if (daftarMenu[i].kategori.equalsIgnoreCase("Minuman")) {
                System.out.println((i + 1) + ". " +
                        daftarMenu[i].nama +
                        " - Rp." +
                        daftarMenu[i].harga);
            }
        }
    }

    // MENU PELANGGAN
    static void menuPelanggan() {

        totalPesanan = 0;

        String pesan;

        do {

            tampilkanMenu();

            System.out.print("\nMasukkan nama menu (ketik selesai): ");
            pesan = input.nextLine();

            if (pesan.equalsIgnoreCase("selesai")) {
                break;
            }

            boolean ditemukan = false;

            for (int i = 0; i < jumlahMenu; i++) {

                if (daftarMenu[i].nama.equalsIgnoreCase(pesan)) {

                    ditemukan = true;

                    System.out.print("Jumlah Pesanan : ");
                    int jumlah = input.nextInt();
                    input.nextLine();

                    pesanan[totalPesanan] = daftarMenu[i].nama;
                    jumlahPesanan[totalPesanan] = jumlah;

                    totalPesanan++;

                    System.out.println("Pesanan berhasil ditambahkan.");
                }
            }

            if (!ditemukan) {
                System.out.println("Menu tidak tersedia!");
            }

        } while (true);

        hitungTotal();
    }

    // HITUNG TOTAL
    static void hitungTotal() {

        int subtotal = 0;
        int totalMinuman = 0;

        System.out.println("\n===== STRUK PEMBAYARAN =====");

        for (int i = 0; i < totalPesanan; i++) {

            for (int j = 0; j < jumlahMenu; j++) {

                if (pesanan[i].equalsIgnoreCase(daftarMenu[j].nama)) {

                    int totalHarga = jumlahPesanan[i] * daftarMenu[j].harga;

                    subtotal += totalHarga;

                    if (daftarMenu[j].kategori.equalsIgnoreCase("Minuman")) {
                        totalMinuman += jumlahPesanan[i];
                    }

                    System.out.println(
                            pesanan[i] +
                                    " x " +
                                    jumlahPesanan[i] +
                                    " = Rp." +
                                    totalHarga
                    );
                }
            }
        }

        // PAJAK
        double pajak = subtotal * 0.10;

        // BIAYA PELAYANAN
        int pelayanan = 20000;

        // DISKON
        double diskon = 0;

        if (subtotal > 100000) {
            diskon = subtotal * 0.10;
        }

        // PROMO BUY 1 GET 1 MINUMAN
        int promo = 0;

        if (subtotal > 50000 && totalMinuman >= 2) {

            for (int i = 0; i < jumlahMenu; i++) {

                if (daftarMenu[i].kategori.equalsIgnoreCase("Minuman")) {
                    promo = daftarMenu[i].harga;
                    break;
                }
            }
        }

        double totalBayar = subtotal + pajak + pelayanan - diskon - promo;

        System.out.println("--------------------------------");
        System.out.println("Subtotal        : Rp." + subtotal);
        System.out.println("Pajak 10%       : Rp." + pajak);
        System.out.println("Biaya Pelayanan : Rp." + pelayanan);
        System.out.println("Diskon          : Rp." + diskon);
        System.out.println("Promo Minuman   : Rp." + promo);
        System.out.println("--------------------------------");
        System.out.println("TOTAL BAYAR     : Rp." + totalBayar);
    }

    // MENU MANAJEMEN
    static void manajemenMenu() {

        int pilih;

        do {

            System.out.println("\n===== MANAJEMEN MENU =====");
            System.out.println("1. Tambah Menu");
            System.out.println("2. Ubah Harga");
            System.out.println("3. Hapus Menu");
            System.out.println("4. Kembali");
            System.out.print("Pilih : ");

            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {

                case 1:
                    tambahMenu();
                    break;

                case 2:
                    ubahHarga();
                    break;

                case 3:
                    hapusMenu();
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Pilihan salah!");
            }

        } while (pilih != 4);
    }

    // TAMBAH MENU
    static void tambahMenu() {

        char lagi;

        do {

            System.out.print("Nama Menu : ");
            String nama = input.nextLine();

            System.out.print("Kategori : ");
            String kategori = input.nextLine();

            System.out.print("Harga : ");
            int harga = input.nextInt();
            input.nextLine();

            daftarMenu[jumlahMenu++] =
                    new Menu(nama, kategori, harga);

            System.out.print("Tambah lagi? (Ya/Tidak) : ");
            lagi = input.next().charAt(0);
            input.nextLine();

        } while (lagi == 'y' || lagi == 'Y');
    }

    // UBAH HARGA
    static void ubahHarga() {

        tampilkanSemuaMenu();

        System.out.print("Pilih nomor menu : ");
        int nomor = input.nextInt();
        input.nextLine();

        if (nomor >= 1 && nomor <= jumlahMenu) {

            System.out.print("Yakin ubah harga? (Ya/Tidak): ");
            String konfirmasi = input.nextLine();

            if (konfirmasi.equalsIgnoreCase("Ya")) {

                System.out.print("Harga Baru : ");
                int hargaBaru = input.nextInt();
                input.nextLine();

                daftarMenu[nomor - 1].harga = hargaBaru;

                System.out.println("Harga berhasil diubah.");
            }
        } else {
            System.out.println("Nomor menu tidak valid!");
        }
    }

    // HAPUS MENU
    static void hapusMenu() {

        tampilkanSemuaMenu();

        System.out.print("Pilih nomor menu : ");
        int nomor = input.nextInt();
        input.nextLine();

        if (nomor >= 1 && nomor <= jumlahMenu) {

            System.out.print("Yakin hapus menu? (Ya/Tidak): ");
            String konfirmasi = input.nextLine();

            if (konfirmasi.equalsIgnoreCase("Ya")) {

                for (int i = nomor - 1; i < jumlahMenu - 1; i++) {
                    daftarMenu[i] = daftarMenu[i + 1];
                }

                jumlahMenu--;

                System.out.println("Menu berhasil dihapus.");
            }

        } else {
            System.out.println("Nomor menu tidak valid!");
        }
    }

    // TAMPILKAN SEMUA MENU
    static void tampilkanSemuaMenu() {

        System.out.println("\n===== DAFTAR MENU =====");

        for (int i = 0; i < jumlahMenu; i++) {

            System.out.println(
                    (i + 1) + ". " +
                            daftarMenu[i].nama +
                            " | " +
                            daftarMenu[i].kategori +
                            " | Rp." +
                            daftarMenu[i].harga
            );
        }
    }
}