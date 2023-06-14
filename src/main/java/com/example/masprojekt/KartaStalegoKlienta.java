package com.example.masprojekt;

import java.io.Serializable;

/**
 * Klasa KartaStalegoKlienta reprezentuje kartę lojalnościową dla klienta.
 * <p>
 * Zapewnia zniżki na naprawy i jest powiązana z konkretnym klientem.
 */
public class KartaStalegoKlienta implements Serializable {
    public static double znizka = 0.15;
    private String dataWydania;
    private String dataWaznosci;
    private Klient klient;

    /**
     * Tworzy nową instancję KartaStalegoKlienta z określoną datą wydania, datą wygaśnięcia i klientem.
     * Karta lojalnościowa jest powiązana z określonym klientem, a karta lojalnościowa klienta jest ustawiona na tę instancję.
     *
     * @param dataWydania  Data wydania karty lojalnościowej.
     * @param dataWaznosci Data wygaśnięcia karty lojalnościowej.
     * @param klient       Klient powiązany z kartą lojalnościową.
     */
    public KartaStalegoKlienta(String dataWydania, String dataWaznosci, Klient klient) {
        this.dataWydania = dataWydania;
        this.dataWaznosci = dataWaznosci;
        this.klient = klient;
        klient.setKartaStalegoKlienta(this);
    }

}
