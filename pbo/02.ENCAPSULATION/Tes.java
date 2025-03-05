// Kelas utama yang menjelaskan Encapsulation
public class Tes {

    // Atribut private, hanya dapat diakses melalui getter/setter
    private String nama;
    private double harga;
    private int stok;

    // Atribut protected, dapat diakses oleh kelas turunannya
    protected String kategori;

    // Atribut public, dapat diakses dari mana saja
    public String status;

    // Konstruktor untuk inisialisasi data produk
    public Tes(String nama, double harga, int stok, String kategori) {
        this.nama = nama;
        setHarga(harga);  // Menggunakan setter untuk validasi harga
        setStok(stok);    // Menggunakan setter untuk validasi stok
        this.kategori = kategori;
        this.status = "Tersedia";  // Status default
    }

    // Getter untuk nama produk
    public String getNama() {
        return nama;
    }

    // Setter untuk nama produk
    public void setNama(String nama) {
        this.nama = nama;
    }

    // Getter untuk harga produk
    public double getHarga() {
        return harga;
    }

    // Setter untuk harga produk dengan validasi
    public void setHarga(double harga) {
        if (harga > 0) {
            this.harga = harga;
        } else {
            System.out.println("Harga harus lebih besar dari 0");
        }
    }

    // Getter untuk stok produk
    public int getStok() {
        return stok;
    }

    // Setter untuk stok produk dengan validasi
    public void setStok(int stok) {
        if (stok >= 0) {
            this.stok = stok;
        } else {
            System.out.println("Stok tidak boleh negatif");
        }
    }

    // Method untuk menampilkan informasi produk
    public void tampilkanInfo() {
        System.out.println("Nama Produk: " + nama);
        System.out.println("Harga: " + harga);
        System.out.println("Stok: " + stok);
        System.out.println("Kategori: " + kategori);
        System.out.println("Status: " + status);
    }

    // Method untuk mengubah status produk
    public void ubahStatus(String statusBaru) {
        status = statusBaru;
        System.out.println("Status produk diubah menjadi: " + status);
    }

    public static void main(String[] args) {
        // Membuat objek produk dengan Encapsulation
        Tes produk = new Tes("Laptop", 10000, 50, "Elektronik");
        
        // Menampilkan informasi produk
        produk.tampilkanInfo();
        
        // Menggunakan setter untuk mengubah harga dan stok produk
        produk.setHarga(12000);  // Harga diubah dengan validasi
        produk.setStok(45);      // Stok diubah dengan validasi
        
        // Menampilkan informasi setelah perubahan
        System.out.println("\nSetelah perubahan:");
        produk.tampilkanInfo();
        
        // Mengubah status produk
        produk.ubahStatus("Tidak Tersedia");
        
        // Menampilkan status terbaru
        System.out.println("\nSetelah perubahan status:");
        produk.tampilkanInfo();

        // Mengakses atribut public kategori langsung
        produk.status = "Diskon 50%";
        System.out.println("\nStatus setelah perubahan langsung: " + produk.status);
        
        // Akses kelas turunan
        KategoriProduk kategoriProduk = new KategoriProduk("Smartphone", 7000, 100, "Elektronik");
        kategoriProduk.tampilkanInfo();
        
        // Mencoba mengakses atribut private 'nama' dan 'harga' langsung (harus gagal)
        System.out.println("\nMencoba mengakses atribut private 'nama' dan 'harga' langsung:");
        // produk.nama = "Tablet";  // Error kompilasi: nama adalah private
        // produk.harga = 15000;    // Error kompilasi: harga adalah private
        // Jika kode ini tidak dikomentari, akan menyebabkan error kompilasi.

        System.out.println("\nMencoba mengakses atribut protected 'kategori' dari kelas lain:");
        // Produk produkLain = new Produk(); // Ini gagal, kategori adalah protected
        System.out.println(produk.kategori);  // Error kompilasi: kategori adalah protected di luar turunan

    }
}

// Kelas turunan yang mengakses protected dan public
class KategoriProduk extends Tes {

    // Konstruktor kelas turunan
    public KategoriProduk(String nama, double harga, int stok, String kategori) {
        super(nama, harga, stok, kategori);  // Memanggil konstruktor kelas induk
    }

    // Menampilkan informasi kategori produk
    public void tampilkanInfo() {
        // Mengakses protected kategori dari kelas induk
        System.out.println("Nama Produk: " + getNama());
        System.out.println("Harga: " + getHarga());
        System.out.println("Stok: " + getStok());
        System.out.println("Kategori: " + kategori);  // Akses protected
        System.out.println("Status: " + status);      // Akses public
    }
}
