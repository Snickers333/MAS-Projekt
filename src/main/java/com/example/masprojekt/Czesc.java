package com.example.masprojekt;

import java.io.Serializable;

public class Czesc implements Serializable {
    private Oddzial oddzial;
    private Smartfon smartfon;
    private Naprawa naprawa;
    private String nazwa;
    private boolean zamiennik;
    private int koszt;
    public Czesc( String nazwa, boolean zamiennik, int koszt) {
        this.nazwa = nazwa;
        this.zamiennik = zamiennik;
        this.koszt = koszt;
    }

    public Oddzial getOddzial() {
        return oddzial;
    }

    public void setOddzial(Oddzial oddzial) {
        this.oddzial = oddzial;
    }

    public Smartfon getSmartfon() {
        return smartfon;
    }

    public void setSmartfon(Smartfon smartfon) {
        this.smartfon = smartfon;
    }

    public Naprawa getNaprawa() {
        return naprawa;
    }

    public void setNaprawa(Naprawa naprawa) {
        this.naprawa = naprawa;
    }

    @Override
    public String toString() {
        return "Czesc{" +
                "nazwa='" + nazwa + '\'' +
                ", zamiennik=" + zamiennik +
                ", koszt=" + koszt +
                '}';
    }
}
