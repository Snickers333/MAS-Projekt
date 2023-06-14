package com.example.masprojekt;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
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
//        Adres adres = new Adres("Polska", "Warszawa", "Skalskiego 1/2", "03-456");
//        Adres adresKier = new Adres("Polska", "Bydgoszcz", "Afrykanska 56", "01-235");
//        Adres adresPrac = new Adres("Polska", "Poznan", "3 Maja 22", "08-475");
//        Adres adresKlie = new Adres("Polska", "Gdynia", "Meksykanska 2/1", "04-282");
//        Kierownik kierownik = new Kierownik("Bartek", "Kaminski", "508612301", "nowy@gmail.com", "bkami", "pass1!", adresKier);
//        Oddzial oddzial = new Oddzial(adres, kierownik);
//        Pracownik pracownik = new Pracownik("Bogdan", "Boner", "282369283", "demo@witam.com", "bboner", "bone1!", true, adresPrac, oddzial);
//
//        Klient klient = new Klient("Karina", "Peczkowska", "789282522", "karin@gmail.com", "kpecz", "piekna1!", adresKlie, oddzial);
//
//        KartaStalegoKlienta kartaStalegoKlienta = new KartaStalegoKlienta("15/06/2023", "15/06/2028", klient);
//
//        Czesc ekran = new Czesc("LCD", false, 120);
//        Czesc szklo = new Czesc("szklo", true, 230);
//        Czesc guzik = new Czesc("guzik", true, 420);
//        Czesc plyta = new Czesc("plyta", true, 940);
//        Czesc bateria = new Czesc("bateria", false, 320);
//
//
//        Producent samsung = new Producent("samsung", "support@samsung.com", 3);
//        Producent apple = new Producent("iphone", "support@icloud.com", 1);
//        Producent xiaomi = new Producent("xiaomi", "support@mi.com", 5);
//        Smartfon galaxy = new Smartfon(samsung, "galaxy", new ArrayList<Czesc>(List.of(ekran, guzik)), 2, klient);
//        Smartfon iphone = new Smartfon(apple, "12 pro max", new ArrayList<Czesc>(List.of(bateria, ekran)), 0, klient);
//        Smartfon redmi = new Smartfon(xiaomi, "redmi 4X", new ArrayList<Czesc>(List.of(plyta, szklo)), 8, klient);
//
//        Naprawa naprawa = new Naprawa(galaxy, pracownik, "14/06/2023", 5, ekran);
//        Naprawa naprawa1 = new Naprawa(redmi, pracownik, "13/06/2023", 2, bateria);
//        Faktura faktura = new Faktura(naprawa, kierownik);
//
//        faktura.getKierownik().getOddzial().getSmartfonyDoOdbioru().add(faktura.getNaprawa().getSmartfon());
//        faktura.getKierownik().getOddzial().getSmartfonyNaprawione().remove(faktura.getNaprawa().getSmartfon());
//
//        IOController.saveDataToFile(oddzial.getAdres(), "adres.txt");
//        IOController.saveDataToFile(oddzial.getKierownik(), "kierownik.txt");
//        IOController.saveDataToFile(oddzial.getSmartfonyDoNaprawy(), "ToFix.txt");
//        IOController.saveDataToFile(oddzial.getSmartfonyNaprawione(), "Fixed.txt");
//        IOController.saveDataToFile(oddzial.getSmartfonyDoOdbioru(), "PickUp.txt");

//        Oddzial oddzial = new Oddzial();
//        System.out.println(oddzial.getSmartfonyDoNaprawy());
//        System.out.println(oddzial.getSmartfonyNaprawione());
//        System.out.println(oddzial.getSmartfonyDoOdbioru());
    }
}