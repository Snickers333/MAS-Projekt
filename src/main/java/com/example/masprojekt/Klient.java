package com.example.masprojekt;

import java.util.ArrayList;
import java.util.List;

public class Klient extends Osoba{
    private Oddzial oddzial;
    private List<Smartfon> smartfonList = new ArrayList<>();
    private KartaStalegoKlienta kartaStalegoKlienta;
    private List<Faktura> fakturyDoOplaty = new ArrayList<>();
    public Klient(String imie, String nazwisko, String numerTelefonu, String email, String login, String haslo, Adres adres, Oddzial oddzial) {
        super(imie, nazwisko, numerTelefonu, email, login, haslo, adres);
        this.oddzial = oddzial;
        this.oddzial.addKlient(this);
    }

    public List<Smartfon> getSmartfonList() {
        return smartfonList;
    }

    public void setSmartfonList(List<Smartfon> smartfonList) {
        this.smartfonList = smartfonList;
    }

    public void addToSmartfonList(Smartfon smartfon) {
        this.smartfonList.add(smartfon);
    }
    public void removeFromSmartfonList(Smartfon smartfon) {
        this.smartfonList.remove(smartfon);
    }

    public KartaStalegoKlienta getKartaStalegoKlienta() {
        return kartaStalegoKlienta;
    }

    public void setKartaStalegoKlienta(KartaStalegoKlienta kartaStalegoKlienta) {
        this.kartaStalegoKlienta = kartaStalegoKlienta;
    }

    public List<Faktura> getFakturyDoOplaty() {
        return fakturyDoOplaty;
    }

    public void setFakturyDoOplaty(List<Faktura> fakturyDoOplaty) {
        this.fakturyDoOplaty = fakturyDoOplaty;
    }

    public Oddzial getOddzial() {
        return oddzial;
    }
}
