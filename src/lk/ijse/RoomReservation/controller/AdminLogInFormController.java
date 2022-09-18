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

public class AdminLogInFormController {
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
        int attempts = 0;
        attempts++;
        if (attempts <= 5) {
            if (txtUserName.getText().equals("admin") && txtPassword.getText().equals("1234")) {
                URL resource = getClass().getResource("../view/AdminHomeForm.fxml");
                Parent load = FXMLLoader.load(resource);
                Stage window = (Stage) rootContext.getScene().getWindow();
                window.setTitle("Admin Section - RRS v0.1");
                window.setScene(new Scene(load));
            } else {
                new Alert(Alert.AlertType.WARNING, "Your username and password is incorrect.!\nYou Have 5 time trys and this is " + attempts + ".").show();
            }
        } else {
            txtUserName.setEditable(false);
            txtPassword.setEditable(false);
            new Alert(Alert.AlertType.WARNING, "Account is Temporarily Disabled or You Did not Sign in Correctly.").show();
        }
    }
}
