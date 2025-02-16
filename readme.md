# Manajemen Sewa Kendaraan

🚗 **Manajemen Sewa Kendaraan** adalah aplikasi manajemen penyewaan kendaraan yang dikembangkan menggunakan **Java** dengan bantuan toolkit **Java Swing** sebagai antarmuka grafis.

## ✨ Fitur Utama

- Manajemen data kendaraan (tambah, edit, hapus, lihat daftar)
- Manajemen kendaraan, monitoring stok kendaraan
- Tersedia Halaman Admin dan Pengguna
- Antarmuka berbasis desktop dengan Java Swing

## 🛠️ Teknologi yang Digunakan

- **Java 21**
- **Apache Maven 3.8.8**
- **Java Swing** untuk UI
- **Database MySQL**

## 📥 Instalasi dan Menjalankan Aplikasi

### 1️⃣ Clone Repository

```sh
 git clone https://github.com/ripscript/manajemen_sewa_kendaraan.git
 cd <nama-direktori-aplikasi>
```

### 2️⃣ Konfigurasi Database

Sebelum membangun aplikasi, lakukan import database yang telah disiapkan di direktori proyek aplikasi. Anda dapat menggunakan MySQL CLI, phpMyAdmin, atau alat lain yang sesuai:

```sh
 mysql -u root -p < manajemen_penyewaan_kendaraan.sql
```

Jika sudah selesai, jangan lupa untuk mengonfigurasi koneksi database yang berada di file `com.example.utils.DatabaseConnection` dengan mengganti nilai berikut sesuai dengan pengaturan database Anda:

```java
private static final String DB_URL = "jdbc:mysql://localhost:4406/manajemen_penyewaan_kendaraan"; // Ganti dengan URL database Anda
private static final String DB_USER = "root"; // Ganti dengan username database Anda
private static final String DB_PASSWORD = "mysql_db_8_0"; // Ganti dengan password database Anda
```




### 3️⃣ Build Aplikasi

```sh
 mvn clean install
```

### 4️⃣ Jalankan Aplikasi

```sh
 mvn exec:java
```

## 💡 Catatan

Pastikan **Java 21** dan **Maven 3.8.8** telah terinstal pada sistem Anda sebelum menjalankan aplikasi ini.

## 📜 Lisensi

Aplikasi ini dirilis di bawah lisensi **MIT**&#x20;

🚀 **Selamat menggunakan aplikasi manajemen sewa kendaraan!**

