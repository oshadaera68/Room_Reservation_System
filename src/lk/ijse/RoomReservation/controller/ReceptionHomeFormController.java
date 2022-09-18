/**
 * @Owner - Oshada Eranga
 * @version - v0.1
 */

package lk.ijse.RoomReservation.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ReceptionHomeFormController {

    public AnchorPane rootContext;

    public void logOutOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ReceptionLogInForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) rootContext.getScene().getWindow();
        window.setTitle("Reception Log In Form - RRS v0.1");
        window.setScene(new Scene(load));
    }

    public void roomOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AvailabilityForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) rootContext.getScene().getWindow();
        window.setTitle("Reception Log In Form - RRS v0.1");
        window.setScene(new Scene(load));
    }

    public void maintanceOnAction(ActionEvent actionEvent) {
    }
}
