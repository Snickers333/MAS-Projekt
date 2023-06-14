package com.example.masprojekt;

import java.io.Serializable;

/**
 * Klasa Naprawa reprezentuje zadanie naprawy wykonywane na smartfonie.
 * <p>
 * Zawiera informacje o naprawianym smartfonie, pracowniku przypisanym do zadania naprawy,
 * dacie naprawy, czasie trwania naprawy, użytej części zamiennej i powiązanej fakturze.
 */
public class Naprawa implements Serializable {
    private Smartfon smartfon;
    private Pracownik pracownik;
    private String data;
    private int dlugoscNaprawy;
    private Czesc czesc;
    private Faktura faktura;

    /**
     * Tworzy nową instancję Naprawa z określonym smartfonem, pracownikiem, datą naprawy, czasem trwania naprawy i częścią zamienną.
     * Smartfon, pracownik i część zamienna są powiązane z zadaniem naprawy.
     * Naprawiony smartfon jest przenoszony z listy smartfonów do naprawy na listę naprawionych smartfonów w powiązanej gałęzi.
     *
     * @param smartfon       Naprawiany smartfon.
     * @param pracownik      Pracownik przypisany do zadania naprawy.
     * @param data           Data naprawy.
     * @param dlugoscNaprawy Czas trwania naprawy w godzinach.
     * @param czesc          Część zamienna użyta w naprawie.
     */
    public Naprawa(Smartfon smartfon, Pracownik pracownik, String data, int dlugoscNaprawy, Czesc czesc) {
        this.smartfon = smartfon;
        this.pracownik = pracownik;
        this.data = data;
        this.dlugoscNaprawy = dlugoscNaprawy;
        this.czesc = czesc;
        this.czesc.setNaprawa(this);
        this.pracownik.addToNaprawaList(this);
        this.smartfon.setNaprawa(this);
        this.smartfon.getKlient().getOddzial().getSmartfonyDoNaprawy().remove(this.smartfon);
        this.smartfon.getKlient().getOddzial().getSmartfonyNaprawione().add(this.smartfon);
    }

    public Faktura getFaktura() {
        return faktura;
    }

    public void setFaktura(Faktura faktura) {
        this.faktura = faktura;
    }

    public int getDlugoscNaprawy() {
        return dlugoscNaprawy;
    }

    public Smartfon getSmartfon() {
        return smartfon;
    }


    @Override
    public String toString() {
        return "Opis Naprawy\n" +
                "\n" +
                "Smartfon:\n" + smartfon + "\n" + "\n" +
                "Wymieniana czesc:\n" + czesc + "\n" + "\n" +
                "Dnia: " + data + "\n" +
                "Czas trwania naprawy: " + dlugoscNaprawy + " godziny\n\n" +
                "Wykonal:\n" + pracownik + "\n" + "\n";
    }
}
