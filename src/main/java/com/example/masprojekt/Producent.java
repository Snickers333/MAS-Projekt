package com.example.masprojekt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa Producent reprezentuje producenta smartfonów.
 * <p>
 * Zawiera atrybuty do przechowywania informacji o producencie i listę smartfonów wyprodukowanych przez producenta.
 */
public class Producent implements Serializable {
    private String nazwa;
    private String email;
    private int czasGwarancji;
    private List<Smartfon> smartfony = new ArrayList<>();

    /**
     * Konstruuje nową instancję Producenta z określonymi informacjami o producencie.
     *
     * @param nazwa         Nazwa producenta.
     * @param email         Adres e-mail producenta.
     * @param czasGwarancji Okres gwarancji podany przez producenta.
     */
    public Producent(String nazwa, String email, int czasGwarancji) {
        this.nazwa = nazwa;
        this.email = email;
        this.czasGwarancji = czasGwarancji;
    }

    public void addSmartfon(Smartfon smartfon) {
        this.smartfony.add(smartfon);
    }

    public int getCzasGwarancji() {
        return czasGwarancji;
    }

    public String getNazwa() {
        return nazwa;
    }

    @Override
    public String toString() {
        return "Producent{" +
                "nazwa='" + nazwa + '\'' +
                ", email='" + email + '\'' +
                ", czasGwarancji=" + czasGwarancji +
                '}';
    }
}
