package com.example.masprojekt;

import java.io.Serializable;

public class Naprawa implements Serializable {
    private Smartfon smartfon;
    private Pracownik pracownik;
    private String data;
    private int dlugoscNaprawy;
    private Czesc czesc;
    private Faktura faktura;

    public Naprawa(Smartfon smartfon, Pracownik pracownik, String data, int dlugoscNaprawy, Czesc czesc) {
        this.smartfon = smartfon;
        this.pracownik = pracownik;
        this.data = data;
        this.dlugoscNaprawy = dlugoscNaprawy;
        this.czesc = czesc;
        this.czesc.setNaprawa(this);
        this.pracownik.addToNaprawaList(this);
        this.smartfon.setNaprawa(this);
        this.smartfon.getKlient().getOddzial().getSmartfonyDoNaprawy().remove(this.smartfon);
        this.smartfon.getKlient().getOddzial().getSmartfonyNaprawione().add(this.smartfon);
    }

    public Faktura getFaktura() {
        return faktura;
    }

    public void setFaktura(Faktura faktura) {
        this.faktura = faktura;
    }

    public int getDlugoscNaprawy() {
        return dlugoscNaprawy;
    }

    public Smartfon getSmartfon() {
        return smartfon;
    }
}
