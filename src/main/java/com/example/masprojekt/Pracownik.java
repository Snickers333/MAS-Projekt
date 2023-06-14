package com.example.masprojekt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa Pracownik reprezentuje pracownika pracującego w oddziale.
 * <p>
 * Rozszerza klasę Osoba i zawiera dodatkowe atrybuty i metody specyficzne dla pracownika.
 */
public class Pracownik extends Osoba {
    private Oddzial oddzial;
    private boolean pelenEtat;
    private List<Smartfon> smartfonList = new ArrayList<>();
    private List<Faktura> fakturaList = new ArrayList<>();
    private List<Naprawa> naprawaList = new ArrayList<>();

    /**
     * Tworzy nową instancję Pracownik z określonymi danymi osobowymi, danymi zatrudnienia, adresem i powiązanym oddziałem.
     * Pracownik jest dodawany do listy pracowników w powiązanym oddziale.
     *
     * @param imie          Imię pracownika.
     * @param nazwisko      Nazwisko pracownika.
     * @param numerTelefonu Numer telefonu pracownika.
     * @param email         Adres e-mail pracownika.
     * @param login         Nazwa użytkownika pracownika.
     * @param haslo         Hasło pracownika.
     * @param pelenEtat     Flaga wskazująca, czy pracownik jest zatrudniony w pełnym czy niepełnym wymiarze godzin.
     * @param adres         Adres pracownika.
     * @param oddzial       Oddział powiązany z pracownikiem.
     */
    public Pracownik(String imie, String nazwisko, String numerTelefonu, String email, String login, String haslo, boolean pelenEtat, Adres adres, Oddzial oddzial) {
        super(imie, nazwisko, numerTelefonu, email, login, haslo, adres);
        this.pelenEtat = pelenEtat;
        this.oddzial = oddzial;
        this.oddzial.addPracownik(this);
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

    public void addToNaprawaList(Naprawa naprawa) {
        this.naprawaList.add(naprawa);
    }

    public void removeFromNaprawaList(Naprawa naprawa) {
        this.naprawaList.remove(naprawa);
    }

    public void addToSmartfonList(Smartfon smartfon) {
        this.smartfonList.add(smartfon);
    }

    public void removeFromSmartfonList(Smartfon smartfon) {
        this.smartfonList.remove(smartfon);
    }
}
