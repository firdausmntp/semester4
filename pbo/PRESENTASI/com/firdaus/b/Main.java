package com.firdaus.b;

import com.firdaus.a.Person;

public class Main {
    public static void main(String[] args) {
        // Buat objek Person
        Person person = new Person("Firdaus", "Tangerang", "Mahasiswa");

        // ✅ Bisa akses public
        System.out.println("Pekerjaan: " + person.occupation);
        person.printOccupation();

        // System.out.println(person.name);

        System.out.println("Nama: " + person.getName());

        // person.printAddress();
    }
}
