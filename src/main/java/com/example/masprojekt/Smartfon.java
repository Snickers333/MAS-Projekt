package com.example.masprojekt;

import java.util.ArrayList;
import java.util.List;

public class Smartfon {
    private Producent producent;
    private String model;
    private List<Czesc> listaCzesci;
    private int wiek;
    private Klient klient;
    private Pracownik pracownik;
    private List<Naprawa> naprawaList = new ArrayList<>();
    public Smartfon(Producent producent, String model, List<Czesc> czesci, int wiek, Pracownik pracownik) {
        this.producent = producent;
        this.producent.addSmartfon(this);
        this.model = model;
        this.listaCzesci = czesci;
        for (Czesc c : listaCzesci) {
            c.setSmartfon(this);
        }
        this.wiek = wiek;
        this.pracownik = pracownik;
        this.pracownik.addToSmartfonList(this);
    }
    public Smartfon(Producent producent, String model, List<Czesc> czesci, int wiek, Klient klient) {
        this.producent = producent;
        this.producent.addSmartfon(this);
        this.model = model;
        this.listaCzesci = czesci;
        for (Czesc c : listaCzesci) {
            c.setSmartfon(this);
        }
        this.wiek = wiek;
        this.klient = klient;
        this.klient.addToSmartfonList(this);
        this.klient.getOddzial().getSmartfonyDoNaprawy().add(this);
    }

    public Klient getKlient() {
        return klient;
    }

    public Pracownik getPracownik() {
        return pracownik;
    }

    public void addToNaprawaList(Naprawa naprawa) {
        this.naprawaList.add(naprawa);
    }
    public void removeFromNaprawaList(Naprawa naprawa) {
        this.naprawaList.remove(naprawa);
    }
    public void addToCzesciList(Czesc czesc) {
        this.listaCzesci.add(czesc);
        czesc.setSmartfon(this);
    }
    public void removeFromCzesciList(Czesc czesc) {
        this.listaCzesci.remove(czesc);
        czesc.setSmartfon(null);
    }

    public Producent getProducent() {
        return producent;
    }

    public int getWiek() {
        return wiek;
    }
}
