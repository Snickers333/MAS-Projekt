package com.example.masprojekt;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * Klasa Faktura reprezentuje fakturę związaną z naprawą.
 * <p>
 * Zawiera informacje o naprawie, koszcie oraz pracowniku lub kierowniku odpowiedzialnym za wystawienie faktury.
 */
public class Faktura implements Serializable {
    private Naprawa naprawa;
    private int koszt;
    private Pracownik pracownik;
    private Kierownik kierownik;

    /**
     * Tworzy nową instancję Faktura z określoną naprawą i pracownikiem.
     * Koszt faktury jest obliczany na podstawie szczegółów naprawy i informacji o kliencie.
     * Faktura jest powiązana z określoną naprawą i dodawana do listy faktur pracownika.
     *
     * @param naprawa   Naprawa powiązana z fakturą.
     * @param pracownik Pracownik odpowiedzialny za wystawienie faktury.
     */
    public Faktura(Naprawa naprawa, Pracownik pracownik) {
        this.naprawa = naprawa;
        this.naprawa.setFaktura(this);
        if (this.naprawa.getSmartfon().statusGwarancji()) {
            this.koszt = 0;
        } else if (naprawa.getSmartfon().getKlient().getKartaStalegoKlienta() != null) {
            this.koszt = (int) ((1 - KartaStalegoKlienta.znizka) * naprawa.getDlugoscNaprawy() * Oddzial.getCenaNaprawyZaGodzine());
        } else {
            this.koszt = naprawa.getDlugoscNaprawy() * Oddzial.getCenaNaprawyZaGodzine();
        }
        this.pracownik = pracownik;
        this.pracownik.addToFakturaList(this);
    }

    /**
     * Tworzy nową instancję Faktura z określoną naprawą i menedżerem.
     * Koszt faktury jest obliczany na podstawie szczegółów naprawy i informacji o kliencie.
     * Faktura jest powiązana z określoną naprawą i dodawana do listy faktur menedżera.
     *
     * @param naprawa   Naprawa powiązana z fakturą.
     * @param kierownik Kierownik odpowiedzialny za wystawienie faktury.
     */
    public Faktura(Naprawa naprawa, Kierownik kierownik) {
        this.naprawa = naprawa;
        if (this.naprawa.getSmartfon().statusGwarancji()) {
            this.koszt = 0;
        } else if (naprawa.getSmartfon().getKlient().getKartaStalegoKlienta() != null) {
            this.koszt = (int) ((1 - KartaStalegoKlienta.znizka) * naprawa.getDlugoscNaprawy() * Oddzial.getCenaNaprawyZaGodzine());
        } else {
            this.koszt = naprawa.getDlugoscNaprawy() * Oddzial.getCenaNaprawyZaGodzine();
        }
        this.kierownik = kierownik;
        this.kierownik.addToFakturaList(this);
    }

    public Pracownik getPracownik() {
        return pracownik;
    }

    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
    }

    public Kierownik getKierownik() {
        return kierownik;
    }

    public void setKierownik(Kierownik kierownik) {
        this.kierownik = kierownik;
    }

    public Naprawa getNaprawa() {
        return naprawa;
    }

    public int getKoszt() {
        return koszt;
    }

    @Override
    public String toString() {
        String result = "Faktura{" +
                "naprawa=" + naprawa +
                ", koszt=" + koszt;
        if (kierownik != null) {
            result = result + ", kierownik=" + kierownik + '}';
        }
        if (pracownik != null) {
            result = result + ", pracownik=" + pracownik + '}';
        }
        return result;
    }

    /**
     * Wystawia fakturę za określoną naprawę smartfona i dane klienta.
     * Faktura jest powiązana z naprawą i tworzona przez określonego pracownika.
     * Szczegóły faktury, w tym informacje o kliencie i koszt, są zapisywane w pliku.
     *
     * @param smartfon    Naprawiany smartfon.
     * @param city        Miasto klienta.
     * @param email       Adres e-mail klienta.
     * @param name        Nazwa klienta.
     * @param phoneNumber Numer telefonu klienta.
     * @param postalCode  Kod pocztowy klienta.
     * @param street      Ulica i numer domu klienta.
     * @param pracownik   Pracownik wystawiający fakturę.
     */
    public static void issueFV(Smartfon smartfon, String city, String email, String name, String phoneNumber, String postalCode, String street, Pracownik pracownik) {
        Faktura fv = new Faktura(smartfon.getNaprawa(), pracownik);
        String resultFV = "Faktura VAT\n\n" +
                "Miasto: " + city + "\n" +
                "Email: " + email + "\n" +
                "Imie i Nazwisko: " + name + "\n" +
                "Numer Telefonu: " + phoneNumber + "\n" +
                "Kod pocztowy: " + postalCode + "\n" +
                "Ulica i numer domu: " + street + "\n\n" +
                smartfon.getNaprawa().toString() +
                "Suma Brutto do zaplaty : " + fv.getKoszt() + " PLN";
        try {
            Files.writeString(Path.of("Faktura.txt"), resultFV, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
