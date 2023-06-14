package com.example.masprojekt;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Faktura implements Serializable {
    private Naprawa naprawa;
    private int koszt;
    private Pracownik pracownik;
    private Kierownik kierownik;

    public Faktura(Naprawa naprawa, Pracownik pracownik) {
        this.naprawa = naprawa;
        this.naprawa.setFaktura(this);
        if (this.naprawa.getSmartfon().statusGwarancji()){
            this.koszt = 0;
        } else if (naprawa.getSmartfon().getKlient().getKartaStalegoKlienta() != null){
            this.koszt = (int) ((1 - KartaStalegoKlienta.znizka) * naprawa.getDlugoscNaprawy() * Oddzial.getCenaNaprawyZaGodzine());
        } else {
            this.koszt = naprawa.getDlugoscNaprawy() * Oddzial.getCenaNaprawyZaGodzine();
        }
        this.pracownik = pracownik;
        this.pracownik.addToFakturaList(this);
    }
    public Faktura(Naprawa naprawa, Kierownik kierownik) {
        this.naprawa = naprawa;
        if (this.naprawa.getSmartfon().statusGwarancji()){
            this.koszt = 0;
        } else if (naprawa.getSmartfon().getKlient().getKartaStalegoKlienta() != null){
            this.koszt = (int) ((1 - KartaStalegoKlienta.znizka) * naprawa.getDlugoscNaprawy() * Oddzial.getCenaNaprawyZaGodzine());
        } else {
            this.koszt = naprawa.getDlugoscNaprawy() * Oddzial.getCenaNaprawyZaGodzine();
        }
        this.kierownik = kierownik;
        this.kierownik.addToFakturaList(this);
    }
//TODO CZY DODAC SMARTFON DO LISTY DO ODBIORU
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

    public static void issueFV (Smartfon smartfon, String city, String email, String name, String phoneNumber, String postalCode, String street, Pracownik pracownik) {
        Faktura fv = new Faktura(smartfon.getNaprawa(), pracownik);
        String resultFV = "Faktura VAT\n\n" +
                "Miasto: " + city+ "\n" +
                "Email: " + email + "\n" +
                "Imie i Nazwisko: " + name + "\n" +
                "Numer Telefonu: " + phoneNumber + "\n" +
                "Kod pocztowy: " + postalCode + "\n" +
                "Ulica i numer domu: " + street + "\n\n" +
                smartfon.getNaprawa().toString()+
                "Suma Brutto do zaplaty : " + fv.getKoszt() + " PLN";
        try {
            Files.writeString(Path.of("Faktura.txt"), resultFV, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
