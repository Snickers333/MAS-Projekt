package com.example.masprojekt;

import java.io.Serializable;

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
}
