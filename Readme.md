# Tugas Praktik 2 - Aplikasi Restoran Sederhana

## Deskripsi Program

Program ini merupakan aplikasi restoran sederhana berbasis Java yang dibuat untuk memenuhi Tugas Praktik 2 Mata Kuliah Pemrograman Berorientasi Objek.

Aplikasi memungkinkan pelanggan untuk melakukan pemesanan makanan dan minuman, menghitung total pembayaran, serta memungkinkan pemilik restoran untuk mengelola daftar menu yang tersedia.

---

## Fitur Program

### 1. Menampilkan Menu Restoran

Program menampilkan daftar menu yang dikelompokkan berdasarkan kategori:

- Makanan
- Minuman

Setiap menu memiliki:

- Nama Menu
- Kategori
- Harga

---

### 2. Pemesanan Menu

Pelanggan dapat:

- Memilih menu berdasarkan nomor menu
- Memasukkan jumlah pesanan
- Menambahkan beberapa pesanan sekaligus
- Mengakhiri pemesanan dengan memilih menu selesai

Program akan melakukan validasi apabila nomor menu yang dipilih tidak tersedia.

---

### 3. Perhitungan Pembayaran

Program menghitung:

- Subtotal pesanan
- Diskon 10% jika subtotal lebih dari Rp100.000
- Promo beli 1 gratis 1 untuk kategori minuman tertentu jika subtotal lebih dari Rp50.000
- Pajak 10%
- Biaya pelayanan Rp20.000

Kemudian program menampilkan total pembayaran akhir.

---

### 4. Cetak Struk

Struk pembayaran menampilkan:

- Daftar pesanan
- Jumlah item
- Harga per item
- Total harga per item
- Subtotal
- Diskon
- Promo minuman
- Pajak
- Biaya pelayanan
- Total pembayaran

---

### 5. Pengelolaan Menu

Pemilik restoran dapat:

#### Tambah Menu

Menambahkan menu baru ke dalam daftar menu restoran.

#### Ubah Harga Menu

Mengubah harga menu berdasarkan nomor menu yang dipilih.

#### Hapus Menu

Menghapus menu berdasarkan nomor menu yang dipilih.

Sebelum perubahan dilakukan, sistem akan meminta konfirmasi terlebih dahulu.

---

## Struktur Program

### File Menu.java

Class Menu digunakan untuk merepresentasikan data menu restoran.

Atribut:

- nama
- kategori
- harga

Method:

- tampilkanMenu()

---

### File Main.java

Class utama yang berisi:

- Menu Utama
- Pemesanan Pelanggan
- Pengelolaan Menu
- Perhitungan Pembayaran
- Cetak Struk

---

## Konsep Pemrograman yang Digunakan

### Class dan Object

Contoh:

```java
Menu menu1 = new Menu("Nasi Goreng", "Makanan", 25000);
```

---

### Array

Digunakan untuk menyimpan:

```java
Menu[] daftarMenu
int[] pesananMenu
int[] pesananJumlah
```

---

### Struktur Keputusan

Program mengimplementasikan:

- if
- if-else
- nested if
- switch-case

---

### Struktur Perulangan

Program mengimplementasikan:

- for
- for-each
- while
- do-while

---

## Cara Menjalankan Program

1. Pastikan Java JDK sudah terinstall.
2. Simpan file:

- Menu.java
- Main.java

3. Compile program:

```bash
javac Menu.java Main.java
```

4. Jalankan program:

```bash
java Main
```

---

## Contoh Menu Awal

### Makanan

1. Nasi Goreng
2. Mie Ayam
3. Ayam Bakar
4. Nasi Padang

### Minuman

5. Es Teh
6. Jus Alpukat
7. Kopi
8. Air Mineral

---

## Identitas Mahasiswa

Nama : [Isi Nama Anda]

NIM : [Isi NIM Anda]

Mata Kuliah : Pemrograman Berorientasi Objek

Tugas : Tugas Praktik 2

---

## Kesimpulan

Program berhasil mengimplementasikan konsep dasar Pemrograman Berorientasi Objek (OOP) menggunakan Java, meliputi penggunaan class, object, method, array, struktur keputusan, dan struktur perulangan sesuai dengan ketentuan Tugas Praktik 2.
