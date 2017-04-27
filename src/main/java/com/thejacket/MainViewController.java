package com.thejacket;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by mariusz on 2017-04-20.
 */
public class MainViewController {

        @FXML
        private Tab StudenciTabButton;

        @FXML
        private Tab PrzedmiotyTabButton;

        @FXML
        private Tab GrupyTabButton;

        @FXML
        private Tab ProtokołyTabButton;

        @FXML
        private Button signOutButton;

        @FXML
        private Text signedAsText;

        @FXML
        void showGrupy(ActionEvent event) {

        }

        @FXML
        void showProtokoły(ActionEvent event) {

        }

        @FXML
        void showPrzedmioty(ActionEvent event) {

        }

        @FXML
        void showStudenci(ActionEvent event) {

        }

        @FXML
        void signOut(ActionEvent event) throws IOException {
            Stage stage;
            Parent root;
            //get reference to the button's stage
            stage = (Stage) signOutButton.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("/signinview.fxml"));
            //create a new scene with root and set the stage
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }

    }

