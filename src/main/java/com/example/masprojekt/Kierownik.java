package com.example.masprojekt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Kierownik extends Osoba{
    private Oddzial oddzial;
    private List<Faktura> fakturaList = new ArrayList<>();
    public Kierownik(String imie, String nazwisko, String numerTelefonu, String email, String login, String haslo, Adres adres) {
        super(imie, nazwisko, numerTelefonu, email, login, haslo, adres);
    }

    public Oddzial getOddzial() {
        return oddzial;
    }

    public void setOddzial(Oddzial oddzial) {
        this.oddzial = oddzial;
    }

    public List<Faktura> getFakturaList() {
        return fakturaList;
    }

    public void setFakturaList(List<Faktura> fakturaList) {
        this.fakturaList = fakturaList;
    }

    public void addToFakturaList(Faktura faktura) {
        fakturaList.add(faktura);
    }

    public void removeFromFakturaList(Faktura faktura) {
        fakturaList.remove(faktura);
    }
}
