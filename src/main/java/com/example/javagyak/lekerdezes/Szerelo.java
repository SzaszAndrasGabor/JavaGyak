package com.example.javagyak.lekerdezes;

import jakarta.persistence.*;

@Entity
@Table(name = "szerelo")
public class Szerelo {
   @Id
   @Column(name = "az")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nev;
    private int kezdev;

    public Szerelo() {

    }

    public int getKezdev() {
        return kezdev;
    }

    public Szerelo( String nev, int kezdev) {

        this.nev = nev;
        this.kezdev = kezdev;
    }



    public void setKezdev(int kezdev) {
        this.kezdev = kezdev;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Szerelo(int id, String nev) {
        this.id = id;
        this.nev = nev;
    }

    public int getId() {
        return id;
    }

    public String getNev() {
        return nev;
    }

    @Override
    public String toString() {
        return nev; // Ezzel jeleníti meg a nevet a ComboBox-ban
    }
}

