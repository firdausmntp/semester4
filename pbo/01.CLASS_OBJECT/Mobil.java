public class Mobil {
    // Mendeklarasikan atribut kelas
    private String merk;
    private String warna;

    // Konstruktor untuk kelas Mobil
    public Mobil(String merk, String warna) {
        this.merk = merk;
        this.warna = warna;
    }

    // Getter untuk atribut merk
    public String getMerk() {
        return merk;
    }

    // Setter untuk atribut merk
    public void setMerk(String merk) {
        this.merk = merk;
    }

    // Getter untuk atribut warna
    public String getWarna() {
        return warna;
    }

    // Setter untuk atribut warna
    public void setWarna(String warna) {
        this.warna = warna;
    }

    // Method untuk menampilkan informasi mobil
    public void tampilkanInfo() {
        System.out.println("Merk Mobil: " + merk);
        System.out.println("Warna Mobil: " + warna);
    }
}