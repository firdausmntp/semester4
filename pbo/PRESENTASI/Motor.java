import java.text.DecimalFormat;

public class Motor {
    // Atribut private, hanya bisa diakses melalui metode setter dan getter
    private String merk;
    private int tahun;
    private double harga;

    // Atribut protected, bisa diakses oleh kelas turunannya
    protected String warna;

    // Atribut public, bisa diakses langsung oleh siapa saja
    public String jenis;

    // Constructor untuk inisialisasi objek Motor
    public Motor(String merk, int tahun, double harga, String warna, String jenis) {
        this.merk = merk;
        this.tahun = tahun;
        this.harga = harga;
        this.warna = warna;
        this.jenis = jenis;
    }

    // Getter dan setter untuk atribut merk (private)
    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    // Getter dan setter untuk atribut tahun (private)
    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    // Getter dan setter untuk atribut harga (private)
    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public void tampilkanInfo() {
        DecimalFormat df = new DecimalFormat("#,###");
        System.out.println("Merk Motor: " + merk);
        System.out.println("Tahun: " + tahun);
        System.out.println("Harga: " + harga);
        System.out.println("Harga: " + df.format(harga));
        System.out.println("Warna: " + warna);
        System.out.println("Jenis: " + jenis);
    }

    // Metode protected yang hanya bisa diakses oleh kelas turunannya
    protected void setWarna(String warna) {
        this.warna = warna;
    }

    // Metode private yang hanya bisa diakses di dalam kelas ini
    private void setHargaDiskon(double diskon) {
        this.harga -= diskon;
    }

    // Main method untuk menjalankan program
    public static void main(String[] args) {
        // Membuat objek Motor
        Motor motor = new Motor("Honda", 2022, 20000000, "Hitam", "Matic");

        // Mengakses informasi motor melalui metode publik
        motor.tampilkanInfo();

        // Mengubah harga dengan setter
        motor.setHarga(19000000);

        // Mengakses warna (protected), hanya bisa dilakukan di kelas turunan atau di dalam kelas ini
        motor.setWarna("Merah");

        // Menampilkan informasi setelah perubahan
        System.out.println("\nSetelah perubahan:");
        motor.tampilkanInfo();

        // Mengakses setter private hanya di dalam kelas ini
        motor.setHargaDiskon(1000000);

        // Menampilkan harga setelah diskon
        System.out.println("\nSetelah diskon:");
        DecimalFormat df = new DecimalFormat("#,###");
        System.out.println("Harga Motor: " + motor.getHarga());
        System.out.println("Harga Motor: " + df.format(motor.getHarga()));
    }
}