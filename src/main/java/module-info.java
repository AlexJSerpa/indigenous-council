module org.example.cabildomanager.view {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.cabildomanager.view to javafx.fxml;
    exports org.example.cabildomanager.view;
    exports org.example.cabildomanager.controller;

}