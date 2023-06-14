package com.example.masprojekt;

import java.io.Serializable;

public class Adres implements Serializable {
    private Oddzial oddzial;
    private Osoba osoba;
    private String panstwo;
    private String miasto;
    private String ulica;
    private String kodPocztowy;

    public Adres(String panstwo, String miasto, String ulica, String kodPocztowy) {
        this.panstwo = panstwo;
        this.miasto = miasto;
        this.ulica = ulica;
        this.kodPocztowy = kodPocztowy;
    }

    public Oddzial getOddzial() {
        return oddzial;
    }

    public void setOddzial(Oddzial oddzial) {
        this.oddzial = oddzial;
    }

    public Osoba getOsoba() {
        return osoba;
    }

    public void setOsoba(Osoba osoba) {
        this.osoba = osoba;
    }
}
