package com.example.masprojekt;

import java.io.Serializable;

/**
 * Klasa Osoba reprezentuje osobę z podstawowymi danymi osobowymi.
 * <p>
 * Służy jako abstrakcyjna klasa bazowa dla określonych typów osób.
 */
public abstract class Osoba implements Serializable {
    private Adres adres;
    private String imie;
    private String nazwisko;
    private String numerTelefonu;
    private String email;
    private String login;
    private String haslo;

    /**
     * Tworzy nową instancję Osoba z określonymi danymi osobowymi i adresem.
     * Adres jest powiązany z osobą, a osoba jest powiązana z adresem.
     *
     * @param imie          Imię osoby.
     * @param nazwisko      Nazwisko osoby.
     * @param numerTelefonu Numer telefonu osoby.
     * @param email         Adres e-mail osoby.
     * @param login         Nazwa logowania osoby.
     * @param haslo         Hasło osoby.
     * @param adres         Adres osoby.
     */
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
