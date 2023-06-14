package com.example.masprojekt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa Kierownik reprezentuje kierownika, który jest specyficznym typem osoby.
 * <p>
 * Rozszerza ona klasę Osoba i dodaje dodatkowe atrybuty i zachowania specyficzne dla kierownika.
 */
public class Kierownik extends Osoba {
    private Oddzial oddzial;
    private List<Faktura> fakturaList = new ArrayList<>();

    /**
     * Tworzy nową instancję Kierownika z określonymi danymi osobowymi i adresem.
     * Kierownik jest powiązany z podanym oddziałem.
     *
     * @param imie          Imię kierownika.
     * @param nazwisko      Nazwisko kierownika.
     * @param numerTelefonu Numer telefonu kierownika.
     * @param email         Adres e-mail menedżera.
     * @param login         Nazwa logowania menedżera.
     * @param haslo         Hasło menedżera.
     * @param adres         Adres menedżera.
     */
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
