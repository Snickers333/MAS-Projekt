package com.example.masprojekt;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class FvController {
    private MenuController menuController;
    private Pracownik pracownik;
    private Smartfon smartfon;
    @FXML
    private Button OkButton;

    @FXML
    private TextField city;

    @FXML
    private TextField email;

    @FXML
    private TextField name;

    @FXML
    private TextField phoneNumber;

    @FXML
    private TextField postalCode;

    @FXML
    private TextField street;

    @FXML
    void onOkButtonClick() {
        Faktura.issueFV(smartfon, city.getText(), email.getText(), name.getText(), phoneNumber.getText(), postalCode.getText(), street.getText(), pracownik);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Prompt.fxml"));
            Parent root = loader.load();
            PromptController promptController = loader.getController();
            promptController.setSmartfon(smartfon);
            Stage promptStage = new Stage();
            promptStage.setScene(new Scene(root));
            promptStage.setTitle("Panel wyboru");
            promptStage.initModality(Modality.APPLICATION_MODAL);
            promptController.setFvStage((Stage) OkButton.getScene().getWindow());
            promptController.setMenuController(this.menuController);
            promptController.setOddzial(menuController.getOddzial());
            promptStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Pracownik getPracownik() {
        return pracownik;
    }

    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
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
}
