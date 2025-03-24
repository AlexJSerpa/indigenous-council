module org.example.cabildomanager.view {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires io.github.cdimascio.dotenv.java;


    opens org.example.cabildomanager.view to javafx.fxml;
    opens org.example.cabildomanager.controller to javafx.fxml;
    exports org.example.cabildomanager.view;
    exports org.example.cabildomanager.controller;

}