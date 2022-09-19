/**
 * @Owner - Oshada Eranga
 * @version - v0.1
 */

package lk.ijse.RoomReservation.controller;

import com.jfoenix.controls.JFXButton;
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
import lk.ijse.RoomReservation.model.Room;
import lk.ijse.RoomReservation.view.tm.RoomTm;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;

public class RoomManagementFormController {
    static ArrayList<Room> rooms = new ArrayList();
    public AnchorPane rootContext;
    public JFXTextField txtRoomId;
    public JFXTextField txtRoomCharges;
    public JFXComboBox cmbRoomType;
    public JFXComboBox cmbAvailableOffers;
    public TableView<RoomTm> tblRoom;
    public TableColumn colRoomId;
    public TableColumn colRoomType;
    public TableColumn colRoomCharges;
    public TableColumn colAvaliableOffers;
    public TableColumn colDelete;
    public JFXButton btnSave;

    public void initialize() {
        colRoomId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colRoomType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colRoomCharges.setCellValueFactory(new PropertyValueFactory<>("charges"));
        colAvaliableOffers.setCellValueFactory(new PropertyValueFactory<>("offers"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("delete"));

        ObservableList<String> obList = FXCollections.observableArrayList();
        obList.add("Single");
        obList.add("Double");
        obList.add("Triple");
        obList.add("Quad");
        cmbRoomType.setItems(obList);

        ObservableList<String> oblist = FXCollections.observableArrayList();
        oblist.add("Yes");
        oblist.add("No");
        cmbAvailableOffers.setItems(oblist);

        loadAllRooms();
        tblRoom.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setData(newValue);
        });
    }

    private void setData(RoomTm tm) {
        btnSave.setText("Update Room");
        txtRoomId.setText(tm.getId());
        txtRoomCharges.setText(tm.getCharges());
        cmbRoomType.getValue();
        cmbAvailableOffers.getValue();
    }

    private void loadAllRooms() {
        ObservableList<RoomTm> roomTms = FXCollections.observableArrayList();
        for (Room rTemp : rooms) {
            Button deleteBtn = new Button("Delete");
            roomTms.add(new RoomTm(rTemp.getId(), rTemp.getType(), rTemp.getCharges(), rTemp.getOffers(), deleteBtn));

            deleteBtn.setOnAction(e -> {
                ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
                ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you Sure to delete Room?", yes, no);
                alert.setTitle("Confirmation Alert");
                alert.setHeaderText(null);
                Optional<ButtonType> result = alert.showAndWait();

                if (result.orElse(no) == yes) {
                    roomTms.remove(rTemp);
                    loadAllRooms();
                } else {

                }
            });
        }
        tblRoom.setItems(roomTms);
    }

    public void saveRoomOnAction(ActionEvent actionEvent) {
        try {
            Room room = new Room(txtRoomId.getText(), cmbRoomType.getValue().toString(), txtRoomCharges.getText(), cmbAvailableOffers.getValue().toString());
            if (ifExist(room)) {
                if (rooms.add(room)) {
                    loadAllRooms();
                    new Alert(Alert.AlertType.CONFIRMATION, "Added Room.").show();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Try Again...!").show();
                }
            } else {
                new Alert(Alert.AlertType.WARNING, "Room Already in List.").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean ifExist(Room room) {
        for (Room r : rooms) {
            if (r.getId().equalsIgnoreCase(room.getId())) {
                return false;
            }
        }
        return true;
    }

    public void btnNewRoomOnAction(ActionEvent actionEvent) {
        btnSave.setText("Save Room");
        txtRoomId.clear();
        txtRoomCharges.clear();
        cmbRoomType.getItems().clear();
        cmbAvailableOffers.getItems().clear();
    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AdminHomeForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) rootContext.getScene().getWindow();
        window.setTitle("Admin Section - RRS v0.1");
        window.setScene(new Scene(load));
    }
}