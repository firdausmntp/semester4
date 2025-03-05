import java.util.ArrayList;
import java.util.Scanner;

public class InventarisBarang {
    
    // Atribut private untuk produk
    private String nama;
    private double harga;
    private int stok;
    
    // Konstruktor untuk produk
    public InventarisBarang(String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Getter dan Setter untuk atribut nama
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    // Getter dan Setter untuk atribut harga
    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        if (harga > 0) {
            this.harga = harga;
        } else {
            System.out.println("Harga tidak valid! (Harus lebih dari 0)");
        }
    }

    // Getter dan Setter untuk atribut stok
    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        if (stok >= 0) {
            this.stok = stok;
        } else {
            System.out.println("Stok tidak boleh negatif!");
        }
    }

    // Menampilkan informasi produk
    public void tampilkanInfo() {
        System.out.println("Nama Produk: " + nama);
        System.out.println("Harga: Rp " + harga);
        System.out.println("Stok: " + stok + " unit");
    }

    // Fungsi untuk membersihkan layar
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error clearing screen.");
        }
    }

    // Kelas utama untuk menjalankan menu
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<InventarisBarang> inventaris = new ArrayList<>();
        
        boolean continueMenu = true;
        
        while (continueMenu) {
            clearScreen(); // Clear the screen before displaying the menu
            System.out.println("\n[*] Menu Inventaris Barang");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Ubah Stok Produk");
            System.out.println("3. Tampilkan Semua Produk");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1/2/3/4): ");
            
            int pilihan = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (pilihan) {
                case 1: // Tambah Produk
                    System.out.print("Masukkan nama produk: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan harga produk: Rp ");
                    double harga = scanner.nextDouble();
                    System.out.print("Masukkan stok produk: ");
                    int stok = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    
                    InventarisBarang produkBaru = new InventarisBarang(nama, harga, stok);
                    inventaris.add(produkBaru);
                    System.out.println("Produk berhasil ditambahkan!");
                    
                    // Menunggu input Enter untuk kembali ke menu
                    System.out.println("Tekan Enter untuk kembali ke menu...");
                    scanner.nextLine();
                    break;

                case 2: // Ubah Stok Produk
                    System.out.print("Masukkan nama produk untuk diubah stok: ");
                    String produkCari = scanner.nextLine();
                    boolean produkDitemukan = false;

                    for (InventarisBarang produk : inventaris) {
                        if (produk.getNama().equalsIgnoreCase(produkCari)) {
                            System.out.print("Masukkan stok baru: ");
                            int stokBaru = scanner.nextInt();
                            produk.setStok(stokBaru);
                            System.out.println("Stok produk berhasil diubah!");
                            produkDitemukan = true;
                            break;
                        }
                    }

                    if (!produkDitemukan) {
                        System.out.println("Produk tidak ditemukan!!");
                    }
                    
                    // Menunggu input Enter untuk kembali ke menu
                    System.out.println("Tekan Enter untuk kembali ke menu...");
                    scanner.nextLine(); // Consume newline
                    scanner.nextLine(); // Wait for Enter key
                    break;

                case 3: // Tampilkan Semua Produk
                    if (inventaris.isEmpty()) {
                        System.out.println("Inventaris kosong! 📉");
                    } else {
                        System.out.println("\n[i] Daftar Inventaris Produk: ");
                        for (InventarisBarang produk : inventaris) {
                            produk.tampilkanInfo();
                            System.out.println("-------------------------------");
                        }
                    }
                    
                    // Menunggu input Enter untuk kembali ke menu
                    System.out.println("Tekan Enter untuk kembali ke menu...");
                    scanner.nextLine();
                    break;

                case 4: // Keluar
                    System.out.println("Terima kasih telah menggunakan aplikasi Inventaris Barang!");
                    continueMenu = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid!!");
                    break;
            }
        }

        scanner.close();
    }
}
