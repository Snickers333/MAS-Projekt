package com.example.masprojekt;

import java.util.ArrayList;
import java.util.List;

public class Oddzial {
    private Adres adres;
    private Kierownik kierownik;
    private List<Czesc> czesci = new ArrayList<>();
    private List<Pracownik> pracownicy = new ArrayList<>();
    private List<Klient> klienci = new ArrayList<>();
    private static int cenaNaprawyZaGodzine = 200;
    private List<Smartfon> smartfonyDoNaprawy = new ArrayList<>();
    private List<Smartfon> smartfonyNaprawione = new ArrayList<>();
    private List<Smartfon> smartfonyDoOdbioru = new ArrayList<>();

    public Oddzial(Adres adres, Kierownik kierownik) {
        this.adres = adres;
        adres.setOddzial(this);
        this.kierownik = kierownik;
        kierownik.setOddzial(this);
    }

    private void addToCzesciList(Czesc czesc) {
        this.czesci.add(czesc);
        czesc.setOddzial(this);
    }
    private void removeFromCzesciList(Czesc czesc) {
        this.czesci.remove(czesc);
        czesc.setOddzial(null);
    }

    public static int getCenaNaprawyZaGodzine() {
        return cenaNaprawyZaGodzine;
    }

    public static void setCenaNaprawyZaGodzine(int cenaNaprawyZaGodzine) {
        Oddzial.cenaNaprawyZaGodzine = cenaNaprawyZaGodzine;
    }

    public List<Smartfon> getSmartfonyDoNaprawy() {
        return smartfonyDoNaprawy;
    }

    public void setSmartfonyDoNaprawy(List<Smartfon> smartfonyDoNaprawy) {
        this.smartfonyDoNaprawy = smartfonyDoNaprawy;
    }

    public List<Smartfon> getSmartfonyNaprawione() {
        return smartfonyNaprawione;
    }

    public void setSmartfonyNaprawione(List<Smartfon> smartfonyNaprawione) {
        this.smartfonyNaprawione = smartfonyNaprawione;
    }

    public List<Smartfon> getSmartfonyDoOdbioru() {
        return smartfonyDoOdbioru;
    }

    public void setSmartfonyDoOdbioru(List<Smartfon> smartfonyDoOdbioru) {
        this.smartfonyDoOdbioru = smartfonyDoOdbioru;
    }
    public void addPracownik(Pracownik pracownik) {
        this.pracownicy.add(pracownik);
    }
    public void addKlient(Klient klient) {
        this.klienci.add(klient);
    }
}
