package com.example.masprojekt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa Klient reprezentuje klienta, który jest określonym typem osoby.
 * <p>
 * Rozszerza ona klasę Osoba i dodaje dodatkowe atrybuty i zachowanie specyficzne dla klienta.
 */
public class Klient extends Osoba {
    private Oddzial oddzial;
    private List<Smartfon> smartfonList = new ArrayList<>();
    private KartaStalegoKlienta kartaStalegoKlienta;
    private List<Faktura> fakturyDoOplaty = new ArrayList<>();

    /**
     * Tworzy nową instancję Klient z określonymi danymi osobowymi, adresem i oddziałem.
     * Klient jest powiązany z określonym oddziałem.
     *
     * @param imie          Imię klienta.
     * @param nazwisko      Nazwisko klienta.
     * @param numerTelefonu Numer telefonu klienta.
     * @param email         Adres e-mail klienta.
     * @param login         Nazwa logowania klienta.
     * @param haslo         Hasło klienta.
     * @param adres         Adres klienta.
     * @param oddzial       Oddział powiązany z klientem.
     */
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
