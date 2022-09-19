/**
 * @Owner - Oshada Eranga
 * @version - v0.1
 */

package lk.ijse.RoomReservation.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.RoomReservation.model.RoomMaintenance;
import lk.ijse.RoomReservation.view.tm.RoomMaintenanceTm;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class MaintanceFormController {

    public static ArrayList<RoomMaintenance> roomList = new ArrayList();
    public AnchorPane rootContext;
    public JFXTextField txtRoomId;
    public JFXComboBox cmbAvailability;
    public TableView tblMain;
    public TableColumn colRoomId;
    public TableColumn colAvailability;
    public TableColumn colMakeAvailable;

    public void initialize() {
        colRoomId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colAvailability.setCellValueFactory(new PropertyValueFactory<>("availability"));
        colMakeAvailable.setCellValueFactory(new PropertyValueFactory<>("available"));

        ObservableList<String> obList1 = FXCollections.observableArrayList();
        obList1.add("Yes");
        obList1.add("No");

        cmbAvailability.setItems(obList1);
        loadAllRooms();
    }

    private void loadAllRooms() {
        ObservableList<RoomMaintenanceTm> tmObservableList = FXCollections.observableArrayList();
        for (RoomMaintenance r : roomList) {
            Button available = new Button("Make Available");
            tmObservableList.add(new RoomMaintenanceTm(r.getId(), r.getAvailability(), available));
            available.setOnAction((e) -> {
                roomList.remove(r);
                loadAllRooms();
            });
        }
        tblMain.setItems(tmObservableList);
    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ReceptionHomeForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) rootContext.getScene().getWindow();
        window.setTitle("Reception Section - RRS v0.1");
        window.setScene(new Scene(load));
    }

    public void homeOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DashBoardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) rootContext.getScene().getWindow();
        window.setTitle("Blue Ocean Hotel - RRS v0.1 - Dashboard");
        window.setScene(new Scene(load));
    }

    public void confirmOnAction(ActionEvent actionEvent) {
        RoomMaintenance room = new RoomMaintenance(txtRoomId.getText(), cmbAvailability.getValue().toString());
        if (ifExist(room)) {
            roomList.add(room);
            loadAllRooms();
            new Alert(Alert.AlertType.CONFIRMATION, "Done", ButtonType.FINISH).showAndWait();
        } else {
            new Alert(Alert.AlertType.WARNING, "Already In Maintenance", ButtonType.OK).showAndWait();
        }
    }

    public boolean ifExist(RoomMaintenance room) {
        for (RoomMaintenance r : roomList) {
            if (r.getId().equalsIgnoreCase(room.getId())) {
                return false;
            }
        }
        return true;
    }

    public void refreshOnAction(ActionEvent actionEvent) {
    }
}
