package com.example.masprojekt;

import java.io.Serializable;

/**
 * Klasa Czesc reprezentuje część używaną w naprawach smartfonów.
 * <p>
 * Zawiera informacje o powiązanym oddziale, smartfonie, naprawie, nazwie, czy jest to część zastępcza i koszcie.
 */
public class Czesc implements Serializable {
    private Oddzial oddzial;
    private Smartfon smartfon;
    private Naprawa naprawa;
    private String nazwa;
    private boolean zamiennik;
    private int koszt;

    /**
     * Konstruuje nową instancję Czesc z określoną nazwą, flagą zastępczą i kosztem.
     *
     * @param nazwa     Nazwa części.
     * @param zamiennik Flaga wskazująca, czy część jest zamiennikiem.
     * @param koszt     Koszt części.
     */
    public Czesc(String nazwa, boolean zamiennik, int koszt) {
        this.nazwa = nazwa;
        this.zamiennik = zamiennik;
        this.koszt = koszt;
    }

    public Oddzial getOddzial() {
        return oddzial;
    }

    public void setOddzial(Oddzial oddzial) {
        this.oddzial = oddzial;
    }

    public Smartfon getSmartfon() {
        return smartfon;
    }

    public void setSmartfon(Smartfon smartfon) {
        this.smartfon = smartfon;
    }

    public Naprawa getNaprawa() {
        return naprawa;
    }

    public void setNaprawa(Naprawa naprawa) {
        this.naprawa = naprawa;
    }

    @Override
    public String toString() {
        return nazwa + "\n" +
                (zamiennik ? "Zamiennik" : "Oryginal") + "\n" +
                koszt + " zl";
    }
}
