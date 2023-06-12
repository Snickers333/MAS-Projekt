module com.example.masprojekt {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.masprojekt to javafx.fxml;
    exports com.example.masprojekt;
}