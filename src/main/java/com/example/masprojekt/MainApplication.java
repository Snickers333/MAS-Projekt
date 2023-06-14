package com.example.masprojekt;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.security.DrbgParameters;
import java.util.ArrayList;
import java.util.List;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Panel sterowania pracownika");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Seed();
        launch();
    }

    private static void Seed() {
        Adres adres = new Adres("Polska", "Warszawa", "Skalskiego 1/2", "03-456");
        Adres adresKier = new Adres("Polska", "Bydgoszcz", "Afrykanska 56", "01-235");
        Adres adresPrac = new Adres("Polska", "Poznan", "3 Maja 22", "08-475");
        Adres adresKlie = new Adres("Polska", "Gdynia", "Meksykanska 2/1", "04-282");
        Kierownik kierownik = new Kierownik("Bartek", "Kaminski", "508612301", "nowy@gmail.com", "bkami", "pass1!", adresKier);
        Oddzial oddzial = new Oddzial(adres, kierownik);
        Pracownik pracownik = new Pracownik("Bogdan", "Boner", "282369283", "demo@witam.com", "bboner", "bone1!", true, adresPrac, oddzial);

        Klient klient = new Klient("Karina", "Peczkowska", "789282522", "karin@gmail.com", "kpecz", "piekna1!", adresKlie, oddzial);

        KartaStalegoKlienta kartaStalegoKlienta = new KartaStalegoKlienta("15/06/2023", "15/06/2028", klient);

        Czesc ekran = new Czesc("LCD", false, 120);
        Czesc szklo = new Czesc("szklo", true, 230);
        Czesc guzik = new Czesc("guzik", true, 420);
        Czesc plyta = new Czesc("plyta", true, 940);
        Czesc bateria = new Czesc("bateria", false, 320);



        Producent samsung = new Producent("samsung", "samsung@support.com", 3);
        Smartfon galaxy = new Smartfon(samsung, "galaxy", new ArrayList<Czesc>(List.of(ekran, guzik)), 2, klient);

        Naprawa naprawa = new Naprawa(galaxy, pracownik, "14/06/2023", 5, ekran);
        Faktura faktura = new Faktura(naprawa, kierownik);
    }
}