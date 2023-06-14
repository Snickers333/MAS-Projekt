package com.example.masprojekt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Oddzial implements Serializable {
    private Adres adres;
    private Kierownik kierownik;
    private List<Czesc> czesci = new ArrayList<>();
    private List<Pracownik> pracownicy = new ArrayList<>();
    private List<Klient> klienci = new ArrayList<>();
    private static int cenaNaprawyZaGodzine = 200;
    private List<Smartfon> smartfonyDoNaprawy;
    private List<Smartfon> smartfonyNaprawione;
    private List<Smartfon> smartfonyDoOdbioru;

    public Oddzial() {
        this.adres = (Adres) IOController.loadObjectFromFile("adres.txt");
        adres.setOddzial(this);
        this.kierownik = (Kierownik) IOController.loadObjectFromFile("kierownik.txt");
        kierownik.setOddzial(this);
        smartfonyDoNaprawy = (List<Smartfon>) IOController.loadObjectFromFile("ToFix.txt");
        smartfonyNaprawione = (List<Smartfon>) IOController.loadObjectFromFile("Fixed.txt");
        smartfonyDoOdbioru = (List<Smartfon>) IOController.loadObjectFromFile("PickUp.txt");
    }

    public Oddzial(Adres adres, Kierownik kierownik) {
        this.adres = adres;
        adres.setOddzial(this);
        this.kierownik = kierownik;
        kierownik.setOddzial(this);
        smartfonyDoNaprawy = new ArrayList<>();
        smartfonyNaprawione = new ArrayList<>();
        smartfonyDoOdbioru = new ArrayList<>();
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

    public Adres getAdres() {
        return adres;
    }

    public Kierownik getKierownik() {
        return kierownik;
    }
}
