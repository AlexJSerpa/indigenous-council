package org.example.cabildomanager.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.cabildomanager.model.DatabaseConfig;
import org.example.cabildomanager.model.UserModel;

/**
 * @author AlexSerpa
 */
public class LoginController {

  @FXML
  private TextField usernameField;

  @FXML
  private TextField passwordField;

  private UserModel userModel = new UserModel();

  @FXML
  public void handleLogin(ActionEvent event) {
    String username = usernameField.getText();
    String password = passwordField.getText();

    if (username.isEmpty() || password.isEmpty()) {
      showAlert(
          "Error",
          " Por favor, ingresa el nombre de usuario y la contraseña."
      );
      return;
    }

    boolean isValidUser = userModel.validateUser(username, password);

    if(isValidUser) {
      showAlert(
          "Éxito",
          "Inicio de sesión exitoso."
      );
      try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
            "/org/example/cabildomanager/view/hello-view.fxml"
        ));
        Parent root = loader.load();
        Stage stage = (Stage) usernameField.getScene().getWindow();
        stage.setScene(new Scene(root));
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else {
      showAlert("Error", "Nombre de usuario o contraseña incorrectos.");
    }
  }

  private void showAlert(String title, String message) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
  }
}
