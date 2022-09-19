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
import lk.ijse.RoomReservation.model.Meal;
import lk.ijse.RoomReservation.view.tm.MealTm;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;

public class MealPackagesFormController {
    static ArrayList<Meal> meals = new ArrayList();
    public AnchorPane rootContext;
    public JFXTextField txtNo;
    public JFXTextField txtName;
    public JFXComboBox cmbType;
    public JFXComboBox cmbTimes;
    public JFXTextField txtPrice;
    public TableView<MealTm> tblMeal;
    public TableColumn colMealNo;
    public TableColumn colType;
    public TableColumn colMealName;
    public TableColumn colTime;
    public TableColumn colPrice;
    public TableColumn colDelete;
    public JFXButton btnSave;

    public void initialize() {
        colMealNo.setCellValueFactory(new PropertyValueFactory<>("no"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colMealName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("delete"));

        ObservableList<String> obList = FXCollections.observableArrayList();
        obList.add("Local Meal");
        obList.add("Chinese Meal");
        obList.add("French Meal");
        cmbType.setItems(obList);

        ObservableList<String> obList1 = FXCollections.observableArrayList();
        obList1.add("Breakfast");
        obList1.add("Lunch");
        obList1.add("Dinner");
        cmbTimes.setItems(obList1);

        loadAllMeals();
        tblMeal.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setData(newValue);
        });

    }

    private void setData(MealTm tm) {
        btnSave.setText("Update Room");
        txtNo.setText(tm.getNo());
        txtName.setText(tm.getName());
        txtPrice.setText(tm.getPrice());
        cmbTimes.getValue();
        cmbType.getValue();
    }

    private void loadAllMeals() {
        ObservableList<MealTm> mealTms = FXCollections.observableArrayList();
        for (Meal mTemp : meals) {
            Button deleteBtn = new Button("Delete");
            mealTms.add(new MealTm(mTemp.getNo(), mTemp.getType(), mTemp.getName(), mTemp.getTime(), mTemp.getPrice(), deleteBtn));

            deleteBtn.setOnAction(e -> {
                ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
                ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you Sure to delete Room?", yes, no);
                alert.setTitle("Confirmation Alert");
                alert.setHeaderText(null);
                Optional<ButtonType> result = alert.showAndWait();

                if (result.orElse(no) == yes) {
                    mealTms.remove(mTemp);
                    loadAllMeals();
                } else {

                }
            });
        }
        tblMeal.setItems(mealTms);
    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AdminHomeForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) rootContext.getScene().getWindow();
        window.setTitle("Admin Section - RRS v0.1");
        window.setScene(new Scene(load));
    }

    public void saveMealOnAction(ActionEvent actionEvent) {
        try {
            Meal meal = new Meal(txtNo.getText(), txtName.getText(), txtPrice.getText(), cmbType.getValue().toString(), cmbTimes.getValue().toString());
            if (ifExist(meal)) {
                if (meals.add(meal)) {
                    loadAllMeals();
                    new Alert(Alert.AlertType.CONFIRMATION, "Meal Saved").show();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Try Again....!").show();
                }
            } else {
                new Alert(Alert.AlertType.WARNING, "meal already in this list").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean ifExist(Meal meal) {
        for (Meal m : meals) {
            if (m.getNo().equalsIgnoreCase(meal.getNo())) {
                return false;
            }
        }
        return true;
    }

    public void newOnAction(ActionEvent actionEvent) {
        btnSave.setText("Save Meal");
        txtNo.clear();
        txtName.clear();
        txtPrice.clear();
        cmbType.getItems().clear();
        cmbTimes.getItems().clear();
    }
}
