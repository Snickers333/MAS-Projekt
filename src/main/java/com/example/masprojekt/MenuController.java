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

public class MenuController implements Initializable {

    private Oddzial oddzial;
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.oddzial = new Oddzial();
        toFixObservable = FXCollections.observableArrayList(oddzial.getSmartfonyDoNaprawy());
        fixedObservable = FXCollections.observableArrayList(oddzial.getSmartfonyNaprawione());
        toCollectObservable = FXCollections.observableArrayList(oddzial.getSmartfonyDoOdbioru());
        toFixList.setItems(toFixObservable);
        fixedList.setItems(fixedObservable);
        toCollectList.setItems(toCollectObservable);
    }

    @FXML
    void onFvButtonClick() {
        Smartfon smartfon = fixedList.getSelectionModel().getSelectedItem();
        if (smartfon != null){

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Fv.fxml"));
            try {
                Parent root = loader.load();
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
}
