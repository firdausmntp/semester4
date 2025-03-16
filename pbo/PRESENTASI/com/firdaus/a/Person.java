package com.firdaus.a;

public class Person {
    // Private: Hanya bisa diakses di dalam kelas ini aja
    private String name;

    // Default (package-private): Bisa diakses oleh kelas dalam package yang sama
    String address;

    public String occupation;

    // Constructor
    public Person(String name, String address, String occupation) {
        this.name = name;
        this.address = address;
        this.occupation = occupation;
    }

    // Getter dan Setter untuk private field
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Method default (package-private)
    public void printAddress() {
        System.out.println("Alamat: " + address);
    }

    // Method public
    public void printOccupation() {
        System.out.println("Pekerjaan: " + occupation);
    }
}
