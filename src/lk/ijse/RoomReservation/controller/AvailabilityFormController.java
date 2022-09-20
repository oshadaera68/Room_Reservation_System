/**
 * @Owner - Oshada Eranga
 * @version - v0.1
 */

package lk.ijse.RoomReservation.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.RoomReservation.db.IncomeDb;
import lk.ijse.RoomReservation.model.RoomMaintenance;
import lk.ijse.RoomReservation.view.tm.AvailabilityTm;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class AvailabilityFormController {

    public AnchorPane rootContext;
    public JFXComboBox<String> cmbRoom;
    public JFXComboBox cmbMeal;
    public JFXDatePicker date1;
    public JFXDatePicker date2;
    public Label roomCost;
    public Label mealPackCost;
    public Label fullCost;
    public JFXButton btnRefresh;
    public JFXComboBox<String> cmbMealName;
    public Label lblTime;
    public Label lblDate;
    public TableView<AvailabilityTm> tblAvailability;
    public TableColumn colId;
    public TableColumn colAvailable;
    public JFXButton btnBooking;

    public void initialize() {
        lblDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

        Timeline time = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            lblTime.setText(currentTime.getHour() + ":" + currentTime.getMinute() + ":" + currentTime.getSecond());
        }),
                new KeyFrame(Duration.seconds(1))
        );
        time.setCycleCount(Animation.INDEFINITE);
        time.play();

        cmbMeal.getItems().addAll("Local Meals", "Chinese Meals", "French Meals");
        cmbMeal.getSelectionModel().select(0);

        ObservableList<String> obList2 = FXCollections.observableArrayList();
        obList2.add("Single Room");
        obList2.add("Double Room");
        obList2.add("Triple Room");
        obList2.add("Quad Room");

        cmbRoom.setItems(obList2);


        colId.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        colAvailable.setCellValueFactory(new PropertyValueFactory<>("roomAvailability"));

        loadAllAvailability();
    }

    private void loadAllAvailability() {
        ObservableList obList = FXCollections.observableArrayList();
        for (RoomMaintenance r : MaintanceFormController.roomList) {
            AvailabilityTm tm = new AvailabilityTm(r.getId(), r.getAvailability());
            obList.add(tm);
        }
        tblAvailability.setItems(obList);
    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ReceptionHomeForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) rootContext.getScene().getWindow();
        window.setTitle("Reception Section - RRS v0.1");
        window.setScene(new Scene(load));
    }

    public void roomTypeOnAction(ActionEvent actionEvent) {
        cmbRoom.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue != newValue) {
                addRooms();
            }
        });
    }

    private void addRooms() {
        if (cmbRoom.getValue().equals("Single Room")) {
            roomCost.setText("2300.00");
        } else if (cmbRoom.getValue().equals("Double Room")) {
            roomCost.setText("5500.00");
        } else if (cmbRoom.getValue().equals("Triple Room")) {
            roomCost.setText("7900.00");
        } else if (cmbRoom.getValue().equals("Quad Room")) {
            roomCost.setText("10500.00");
        }
    }

    public void selectMealPackOnAction(ActionEvent actionEvent) {
        cmbMeal.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue != newValue) {
                cmbMealName.getItems().clear();
                addMeals();
            }
        });
    }

    public void d1SelectOnAction(ActionEvent actionEvent) {
        enableRefreshButton();
    }

    public void d2SelectOnAction(ActionEvent actionEvent) {
        enableRefreshButton();
    }

    private void enableRefreshButton() {
        try {
            if (!cmbRoom.getValue().equals("") && !date1.getValue().toString().equals("") && date2.getValue().toString().equals("")) {
                btnRefresh.setDisable(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void enableBookingButton() {
        try {
            if (!cmbRoom.getValue().equals("") && !date1.getValue().toString().equals("") && date2.getValue().toString().equals("")) {
                btnBooking.setDisable(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void refreshOnAction(ActionEvent actionEvent) {
        addRooms();
        addMeals();

        LocalDate date = LocalDate.now();
        LocalDate date1 = date2.getValue();

        int range = date1.getDayOfMonth() - date.getDayOfMonth();
        double rc = Double.parseDouble(roomCost.getText());
        double mp = Double.parseDouble(mealPackCost.getText());
        double cost = ((rc + mp) * range);
        String s = String.valueOf(cost);
        fullCost.setText(s);
        date.getMonthValue();
        date.getYear();
        date.getMonth();
        enableBookingButton();
    }

    public void paymentAfterOnAction(ActionEvent actionEvent) {

    }

    public void paymentNowOnAction(ActionEvent actionEvent) {
        LocalDate date = date2.getValue();
        for (int i = 0; i < IncomeDb.monthIncome.size(); i++) {
            try {
                if ((i + 1) == date.getMonthValue()) {
                    double earlyIncome = IncomeDb.monthIncome.get(i).getIncome();
                    IncomeDb.monthIncome.get(i).setIncome(Math.abs(earlyIncome + Double.parseDouble(fullCost.getText())));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void mealNameClick(ActionEvent actionEvent) {
        cmbMealName.getItems().clear();
        addMeals();
    }

    private void addMeals() {
        if (cmbMeal.getValue().toString().equals("Local Meals")) {
            cmbMealName.getItems().addAll("Pizza, biriyani, Chicken Rice");
            cmbMealName.getSelectionModel().select(0);
            if (cmbMealName.getValue().equals("Pizza")) {
                mealPackCost.setText("500.00");
            } else if (cmbMealName.getValue().equals("biriyani")) {
                mealPackCost.setText("1500.00");
            } else if (cmbMealName.getValue().equals("Chicken Rice")) {
                mealPackCost.setText("790.00");
            }
        } else if (cmbMeal.getValue().toString().equals("Chinese Meals")) {
            cmbMealName.getItems().addAll("Spring Rolls, Dumplings, Wonton");
            cmbMealName.getSelectionModel().select(0);
            if (cmbMealName.getValue().equals("Spring Rolls")) {
                mealPackCost.setText("950.00");
            } else if (cmbMealName.getValue().equals("Dumplings")) {
                mealPackCost.setText("1200.00");
            } else if (cmbMealName.getValue().equals("Wonton")) {
                mealPackCost.setText("1250.00");
            }
        } else if (cmbMeal.getValue().toString().equals("French Meals")) {
            cmbMealName.getItems().addAll("Burger, Shawarma, Prawns");
            cmbMealName.getSelectionModel().select(0);
            if (cmbMealName.getValue().equals("Burger")) {
                mealPackCost.setText("450.00");
            } else if (cmbMealName.getValue().equals("Shawarma")) {
                mealPackCost.setText("600.00");
            } else if (cmbMealName.getValue().equals("Prawns")) {
                mealPackCost.setText("700.00");
            }
        }
    }

    public void bookingOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/GuestDetailsForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) rootContext.getScene().getWindow();
        window.setTitle("Guest Details Form - RRS v0.1");
        window.setScene(new Scene(load));
    }
}
