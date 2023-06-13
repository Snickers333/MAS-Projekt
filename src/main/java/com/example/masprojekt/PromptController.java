package com.example.masprojekt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PromptController {
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
        promptStage.close();
        fvStage.close();
    }

    @FXML
    void onYesButtonClick() {
        Stage promptStage = (Stage) yesButton.getScene().getWindow();
        promptStage.close();
        fvStage.close();
    }
}
