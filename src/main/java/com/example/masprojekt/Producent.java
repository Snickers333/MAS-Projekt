package com.example.masprojekt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Producent implements Serializable {
    private String nazwa;
    private String email;
    private int czasGwarancji;
    private List<Smartfon> smartfony = new ArrayList<>();

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
