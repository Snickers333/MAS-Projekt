package com.example.masprojekt;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Klasa MenuController implementuje interfejs Initializable i służy jako kontroler dla widoku "Menu.fxml".
 * Zawiera metody obsługi zdarzeń i inicjalizuje elementy interfejsu użytkownika podczas inicjalizacji.
 */
public class MenuController implements Initializable {

    private Oddzial oddzial;
    private Pracownik pracownik;
    @FXML
    private Button FvButton;
    private ObservableList<Smartfon> toFixObservable;
    @FXML
    private ListView<Smartfon> toFixList;
    private ObservableList<Smartfon> fixedObservable;
    @FXML
    private ListView<Smartfon> fixedList;
    private ObservableList<Smartfon> toCollectObservable;
    @FXML
    private ListView<Smartfon> toCollectList;

    /**
     * Metoda initialize() jest wywoływana po załadowaniu pliku FXML.
     * Inicjalizuje ona kontroler i ustawia elementy interfejsu użytkownika.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.oddzial = new Oddzial();
        this.pracownik = new Pracownik("Boguslaw", "Wieczorek", "352868321", "bwieczorek@gmail.com", "bwieczor", "wieczor1!", true, new Adres("Polska", "Pultusk", "Sloneczna 9", "04-153"), oddzial);
        toFixObservable = FXCollections.observableArrayList(oddzial.getSmartfonyDoNaprawy());
        fixedObservable = FXCollections.observableArrayList(oddzial.getSmartfonyNaprawione());
        toCollectObservable = FXCollections.observableArrayList(oddzial.getSmartfonyDoOdbioru());
        toFixList.setItems(toFixObservable);
        fixedList.setItems(fixedObservable);
        toCollectList.setItems(toCollectObservable);
    }

    /**
     * Metoda onFvButtonClick() jest wywoływana po kliknięciu przycisku "FvButton".
     * Otwiera ona widok "Fv.fxml" i konfiguruje kontroler FvController.
     */
    @FXML
    void onFvButtonClick() {
        Smartfon smartfon = fixedList.getSelectionModel().getSelectedItem();
        if (smartfon != null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Fv.fxml"));
            try {
                Parent root = loader.load();
                FvController fvController = loader.getController();
                fvController.setSmartfon(smartfon);
                fvController.setPracownik(pracownik);
                fvController.setMenuController(this);
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Wystaw Fakturę");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    /**
     * Metoda exit() jest wywoływana po wybraniu opcji "Exit".
     * Kończy ona działanie aplikacji.
     */
    @FXML
    void exit() {
        System.exit(0);
    }

    public ObservableList<Smartfon> getToFixObservable() {
        return toFixObservable;
    }

    public void setToFixObservable(ObservableList<Smartfon> toFixObservable) {
        this.toFixObservable = toFixObservable;
    }

    public ListView<Smartfon> getToFixList() {
        return toFixList;
    }

    public void setToFixList(ListView<Smartfon> toFixList) {
        this.toFixList = toFixList;
    }

    public ObservableList<Smartfon> getFixedObservable() {
        return fixedObservable;
    }

    public void setFixedObservable(ObservableList<Smartfon> fixedObservable) {
        this.fixedObservable = fixedObservable;
    }

    public ListView<Smartfon> getFixedList() {
        return fixedList;
    }

    public void setFixedList(ListView<Smartfon> fixedList) {
        this.fixedList = fixedList;
    }

    public ObservableList<Smartfon> getToCollectObservable() {
        return toCollectObservable;
    }

    public void setToCollectObservable(ObservableList<Smartfon> toCollectObservable) {
        this.toCollectObservable = toCollectObservable;
    }

    public ListView<Smartfon> getToCollectList() {
        return toCollectList;
    }

    public void setToCollectList(ListView<Smartfon> toCollectList) {
        this.toCollectList = toCollectList;
    }

    public Oddzial getOddzial() {
        return oddzial;
    }

    public void setOddzial(Oddzial oddzial) {
        this.oddzial = oddzial;
    }
}
