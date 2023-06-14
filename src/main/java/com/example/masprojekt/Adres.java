package com.example.masprojekt;

import java.io.Serializable;
/**
 Klasa Adres reprezentuje adres powiązany z oddziałem lub osobą.

 Przechowuje informacje o kraju, mieście, ulicy i kodzie pocztowym.
 */
public class Adres implements Serializable {
    private Oddzial oddzial;
    private Osoba osoba;
    private String panstwo;
    private String miasto;
    private String ulica;
    private String kodPocztowy;
    /**

     Konstruuje nową instancję Adres z określonym krajem, miastem, ulicą i kodem pocztowym.
     @param panstwo Kraj adresu.
     @param miasto Miasto adresu.
     @param ulica Ulica adresu.
     @param kodPocztowy Kod pocztowy adresu.
     */
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
