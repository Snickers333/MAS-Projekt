package com.example.masprojekt;

import java.io.Serializable;

public abstract class Osoba implements Serializable {
    private Adres adres;
    private String imie;
    private String nazwisko;
    private String numerTelefonu;
    private String email;
    private String login;
    private String haslo;

    public Osoba(String imie, String nazwisko, String numerTelefonu, String email, String login, String haslo, Adres adres) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.numerTelefonu = numerTelefonu;
        this.email = email;
        this.login = login;
        this.haslo = haslo;
        this.adres = adres;
        this.adres.setOsoba(this);
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko + "\n" + email;
    }
}
