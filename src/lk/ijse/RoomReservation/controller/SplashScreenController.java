/**
 * @Owner - Oshada Eranga
 * @version - v0.1
 */

package lk.ijse.RoomReservation.controller;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SplashScreenController implements Initializable {
    public ProgressBar progressBar;
    public ProgressIndicator progressIndicator;
    public AnchorPane rootContext;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        new ShowSplashScreen().start();
    }

    class ShowSplashScreen extends Thread {
        public void run() {
            try {
                for (int i = 0; i <= 10; i++) {
                    // prograssind.setVisible(false);
                    double x = i * (0.1);
                    //System.out.println(x);
                    progressBar.setProgress(x);
                    progressIndicator.setProgress(x);

                    if (i * 10 == 100) {
                        progressBar.setVisible(true);
                        progressIndicator.setProgress(1);
                    }

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Platform.runLater(() -> {
                    Stage stage = new Stage();
                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("../view/DashBoardForm.fxml"));
                    } catch (IOException ex) {
                        Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setTitle("Blue Ocean Hotel - RRS v0.1 - Dashboard");
                    stage.setFullScreen(false);
                    stage.setResizable(false);
                    stage.show();
                    rootContext.getScene().getWindow().hide();
                });
            } catch (Exception ex) {
                Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
