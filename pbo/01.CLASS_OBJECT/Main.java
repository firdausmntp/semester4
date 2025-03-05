public class Main {
    public static void main(String[] args) {
        // Membuat objek mobil1 dari kelas Mobil
        Mobil mobil1 = new Mobil("Toyota", "Merah");

        // Menampilkan informasi mobil
        mobil1.tampilkanInfo();

        // Mengubah warna mobil menggunakan setter
        mobil1.setWarna("Hitam");

        // Menampilkan informasi mobil setelah perubahan
        System.out.println("\nSetelah perubahan warna:");
        mobil1.tampilkanInfo();
    }
}
