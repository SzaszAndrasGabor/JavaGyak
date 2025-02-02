package com.example.javagyak.lekerdezes;


import jakarta.persistence.*;


@Entity
@Table(name = "munkalap")
public class Munkalap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "az")
    public int az;

    @Column(name = "bedatum")
    public String bedatum;

    @Column(name = "javdatum")
    public String javdatum;

    @Column(name = "helyaz")

    public int helyaz;

    @Column(name = "szereloaz")


    public int szereloaz;
    @Column(name = "munkaora")
    public int munkaora;
    @Column(name = "anyagar")
    public int anyagar;





    public Munkalap() {
    }

    public Munkalap( String bedatum, String javdatum, int helyaz, int szeraz, int munkaora, int anyagar) {

        this.bedatum = bedatum;
        this.javdatum = javdatum;
        this.helyaz = helyaz;
        this.szereloaz = szeraz;
        this.munkaora = munkaora;
        this.anyagar = anyagar;
    }

    public String getBedatum() {
        return bedatum;
    }

    public int getAz() {
        return az;
    }

    public void setAz(int az) {
        this.az = az;
    }

    public void setBedatum(String bedatum) {
        this.bedatum = bedatum;
    }

    public String getJavdatum() {
        return javdatum;
    }

    public void setJavdatum(String javdatum) {
        this.javdatum = javdatum;
    }

    public int getHelyaz() {
        return helyaz;
    }

    public void setHelyaz(int helyaz) {
        this.helyaz = helyaz;
    }

    public int getSzeraz() {
        return szereloaz;
    }

    public void setSzeraz(int szeraz) {
        this.szereloaz = szeraz;
    }

    public int getMunkaora() {
        return munkaora;
    }

    public void setMunkaora(int munkaora) {
        this.munkaora = munkaora;
    }

    public int getAnyagar() {
        return anyagar;
    }

    public void setAnyagar(int anyagar) {
        this.anyagar = anyagar;
    }
}
