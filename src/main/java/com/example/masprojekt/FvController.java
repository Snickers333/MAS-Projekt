package com.example.masprojekt;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class FvController {
    @FXML
    private Button OkButton;
    @FXML
    void onOkButtonClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Prompt.fxml"));
            Parent root = loader.load();

            Stage promptStage = new Stage();
            promptStage.setScene(new Scene(root));
            promptStage.setTitle("Panel wyboru");
            promptStage.initModality(Modality.APPLICATION_MODAL);

            PromptController promptController = loader.getController();
            promptController.setFvStage((Stage) OkButton.getScene().getWindow());

            promptStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
