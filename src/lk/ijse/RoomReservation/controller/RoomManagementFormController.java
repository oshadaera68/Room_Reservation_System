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
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.RoomReservation.view.tm.RoomTm;

import java.net.URL;
import java.util.ResourceBundle;

public class RoomManagementFormController implements Initializable {
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
    }

    public void saveRoomOnAction(ActionEvent actionEvent) {
    }

    public void btnNewRoomOnAction(ActionEvent actionEvent) {
    }

    public void backOnAction(ActionEvent actionEvent) {
    }
}
