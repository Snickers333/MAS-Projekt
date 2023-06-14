package com.example.masprojekt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    @FXML
    private Button FvButton;
    @FXML
    private ListView<?> fixedList;

    @FXML
    private ListView<?> toCollectList;

    @FXML
    private ListView<?> toFixList;

    @FXML
    void onFvButtonClick() {
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
