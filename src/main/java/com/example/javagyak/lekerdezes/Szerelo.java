package com.example.javagyak.lekerdezes;

public class Szerelo {
    private int id;
    private String nev;
    private int kezdev;

    public int getKezdev() {
        return kezdev;
    }

    public Szerelo(int id, String nev, int kezdev) {
        this.id = id;
        this.nev = nev;
        this.kezdev = kezdev;
    }

    public Szerelo(String nev, int kezdev) {
        this.nev = nev;
        this.kezdev = kezdev;
    }

    public void setKezdev(int kezdev) {
        this.kezdev = kezdev;
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

