/**
 * @Owner - Oshada Eranga
 * @version - v0.1
 */

package lk.ijse.RoomReservation.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

import java.util.Random;

public class PrintTokenFormController {
    public Label label1;

    public void sendMailOnAction(ActionEvent actionEvent) {
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION, "Are you want to Mail Send?", ButtonType.YES, ButtonType.NO);
        alert1.setHeaderText(null);
        alert1.showAndWait();
    }

    public void generateIdOnAction(ActionEvent actionEvent) {
        Random r = new Random();
        label1.setText(String.valueOf(r.nextInt(200)));
    }

    public void printTokenOnAction(ActionEvent actionEvent) {
        Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION, "Are you want to Token Print?", ButtonType.YES, ButtonType.NO);
        alert2.setHeaderText(null);
        alert2.showAndWait();
    }
}
