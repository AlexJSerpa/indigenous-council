module org.example.cabildomanager.view {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.cabildomanager.view to javafx.fxml;
    exports org.example.cabildomanager.view;

}