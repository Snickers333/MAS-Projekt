package com.example.masprojekt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PromptController {
    private Oddzial oddzial;
    private MenuController menuController;
    private Smartfon smartfon;
    @FXML
    private Button noButton;

    @FXML
    private Button yesButton;

    private Stage fvStage;

    public void setFvStage(Stage stage) {
        this.fvStage = stage;
    }

    @FXML
    void onNoButtonClick() {
        Stage promptStage = (Stage) noButton.getScene().getWindow();
        saveChanges();
        promptStage.close();
        fvStage.close();
    }

    @FXML
    void onYesButtonClick() {
        Stage promptStage = (Stage) yesButton.getScene().getWindow();
        getMenuController().getFixedObservable().remove(smartfon);
        getMenuController().getToCollectObservable().add(smartfon);
        oddzial.getSmartfonyNaprawione().remove(smartfon);
        oddzial.getSmartfonyDoOdbioru().add(smartfon);
        saveChanges();
        promptStage.close();
        fvStage.close();
    }

    public void saveChanges(){
        IOController.saveDataToFile(oddzial.getAdres(), "adres.txt");
        IOController.saveDataToFile(oddzial.getKierownik(), "kierownik.txt");
        IOController.saveDataToFile(oddzial.getSmartfonyDoNaprawy(), "ToFix.txt");
        IOController.saveDataToFile(oddzial.getSmartfonyNaprawione(), "Fixed.txt");
        IOController.saveDataToFile(oddzial.getSmartfonyDoOdbioru(), "PickUp.txt");
    }

    public Smartfon getSmartfon() {
        return smartfon;
    }

    public void setSmartfon(Smartfon smartfon) {
        this.smartfon = smartfon;
    }

    public MenuController getMenuController() {
        return menuController;
    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    public Oddzial getOddzial() {
        return oddzial;
    }

    public void setOddzial(Oddzial oddzial) {
        this.oddzial = oddzial;
    }
}
