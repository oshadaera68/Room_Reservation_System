/**
 * @Owner - Oshada Eranga
 * @version - v0.1
 */

package lk.ijse.RoomReservation.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ReceptionLogInFormController {
    public AnchorPane rootContext;
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/LogInForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) rootContext.getScene().getWindow();
        window.setTitle("Log In Form - RRS v0.1");
        window.setScene(new Scene(load));
    }

    public void logInOnAction(ActionEvent actionEvent) throws IOException {
        if (txtPassword.getText().equals("1111") & txtUserName.getText().equalsIgnoreCase("era")) {
            URL resource = getClass().getResource("../view/ReceptionHomeForm.fxml");
            Parent load = FXMLLoader.load(resource);
            Stage window = (Stage) rootContext.getScene().getWindow();
            window.setTitle("Reception Section - RRS v0.1");
            window.setScene(new Scene(load));
        } else {
            new Alert(Alert.AlertType.WARNING,"Enter correct username or password").show();
        }
    }
}
