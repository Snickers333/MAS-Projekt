package com.example.masprojekt;

import java.io.Serializable;

public class KartaStalegoKlienta implements Serializable {
    public static double znizka = 0.15;
    private String dataWydania;
    private String dataWaznosci;
    private Klient klient;

    public KartaStalegoKlienta(String dataWydania, String dataWaznosci, Klient klient) {
        this.dataWydania = dataWydania;
        this.dataWaznosci = dataWaznosci;
        this.klient = klient;
        klient.setKartaStalegoKlienta(this);
    }

}
