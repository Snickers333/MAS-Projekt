package com.example.masprojekt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa Smartfon reprezentuje smartfon.
 * <p>
 * Zawiera atrybuty do przechowywania informacji o smartfonie, takich jak producent, model, części, wiek i powiązane jednostki.
 */
public class Smartfon implements Serializable {
    private Producent producent;
    private String model;
    private List<Czesc> listaCzesci;
    private int wiek;
    private Klient klient;
    private Pracownik pracownik;
    private Naprawa naprawa;

    /**
     * Konstruuje nową instancję Smartfon z określonymi informacjami o smartfonie i powiązanym Pracowniku.
     *
     * @param producent Producent smartfona.
     * @param model     Model smartfona.
     * @param czesci    Lista części/komponentów smartfona.
     * @param wiek      Wiek smartfona.
     * @param pracownik Pracownik przypisany do smartfona.
     */
    public Smartfon(Producent producent, String model, List<Czesc> czesci, int wiek, Pracownik pracownik) {
        this.producent = producent;
        this.producent.addSmartfon(this);
        this.model = model;
        this.listaCzesci = czesci;
        for (Czesc c : listaCzesci) {
            c.setSmartfon(this);
        }
        this.wiek = wiek;
        this.pracownik = pracownik;
        this.pracownik.addToSmartfonList(this);
    }

    /**
     * Tworzy nową instancję Smartfon z określonymi informacjami o smartfonie i powiązanym Kliencie.
     *
     * @param producent Producent smartfona.
     * @param model     Model smartfona.
     * @param czesci    Lista części/komponentów smartfona.
     * @param wiek      Wiek smartfona.
     * @param klient    Klient, który jest właścicielem smartfona.
     */
    public Smartfon(Producent producent, String model, List<Czesc> czesci, int wiek, Klient klient) {
        this.producent = producent;
        this.producent.addSmartfon(this);
        this.model = model;
        this.listaCzesci = czesci;
        for (Czesc c : listaCzesci) {
            c.setSmartfon(this);
        }
        this.wiek = wiek;
        this.klient = klient;
        this.klient.addToSmartfonList(this);
        this.klient.getOddzial().getSmartfonyDoNaprawy().add(this);
    }

    /**
     * Sprawdza, czy smartfon jest nadal objęty gwarancją.
     * Zwraca true, jeśli smartfon jest objęty gwarancją, false w przeciwnym razie.
     */
    public boolean statusGwarancji() {
        if (this.producent.getCzasGwarancji() > this.wiek) {
            return true;
        } else {
            return false;
        }
    }

    public Klient getKlient() {
        return klient;
    }

    public Pracownik getPracownik() {
        return pracownik;
    }

    public Naprawa getNaprawa() {
        return this.naprawa;
    }

    public void setNaprawa(Naprawa naprawa) {
        this.naprawa = naprawa;
    }

    public void addToCzesciList(Czesc czesc) {
        this.listaCzesci.add(czesc);
        czesc.setSmartfon(this);
    }

    public void removeFromCzesciList(Czesc czesc) {
        this.listaCzesci.remove(czesc);
        czesc.setSmartfon(null);
    }

    public Producent getProducent() {
        return producent;
    }

    public int getWiek() {
        return wiek;
    }

    @Override
    public String toString() {
        return producent.getNazwa() + " " + model + "\n" +
                "Wiek: " + wiek + " lat" + "\n" +
                "Gwarancja: " + statusGwarancji();
    }
}
