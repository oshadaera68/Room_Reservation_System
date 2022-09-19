/**
 * @Owner - Oshada Eranga
 * @version - v0.1
 */

package lk.ijse.RoomReservation.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.RoomReservation.db.IncomeDb;
import lk.ijse.RoomReservation.view.tm.IncomeTm;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class IncomeReportsFormController {
    public AnchorPane rootContext;
    public JFXComboBox cmbMonth;
    public JFXComboBox cmbYear;
    public TableView<IncomeTm> tblMonth;
    public TableColumn colMonth;
    public TableColumn colMonIncome;
    public TableView tblYear;
    public TableColumn colYear;
    public TableColumn colIncome;
    public Label lblTime;
    public Label lblDate;
    
    public void initialize(){
        loadDateAndTime();
        loadAllIncomes();

        ObservableList<String> obList1 = FXCollections.observableArrayList();
        obList1.add("January");
        cmbMonth.getSelectionModel().select(0);

        cmbMonth.setItems(obList1);

        ObservableList<String> obList2 = FXCollections.observableArrayList();
        obList2.add("2021");
        cmbYear.getSelectionModel().select(0);

        cmbYear.setItems(obList2);

    }

    private void loadAllIncomes() {
        ObservableList observableList= FXCollections.observableArrayList();
        for (IncomeTm tm: IncomeDb.monthIncome) {
            observableList.add(tm);
        }
        tblMonth.setItems(observableList);
    }

    private void loadDateAndTime() {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        lblDate.setText(f.format(date));

        //load time
        Timeline time = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            lblTime.setText(
                    currentTime.getHour() + ":" + currentTime.getMinute() + ":" + currentTime.getSecond()
            );
        }),
                new KeyFrame(Duration.seconds(1))
        );
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AdminHomeForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) rootContext.getScene().getWindow();
        window.setTitle("Admin Section - RRS v0.1");
        window.setScene(new Scene(load));
    }

    public void refreshOnAction(ActionEvent actionEvent) {
        loadAllIncomes();
    }
}