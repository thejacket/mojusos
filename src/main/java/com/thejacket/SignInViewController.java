package com.thejacket;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Timer;

/**
 * Created by mariusz on 2017-04-20.
 */
public class SignInViewController {

    @FXML
    private PasswordField loginField;
    @FXML
    private PasswordField pwField;
    @FXML
    private Button signInButton;

    private String loginArg = "admin";
    private String pwArg = "admin";

    @FXML
    private Text WrongCredentialsText;

    @FXML
    void signIn(ActionEvent event) throws IOException {
        if (loginField.getText().equals(loginArg) && pwField.getText().equals(pwArg)) {
            Authentication.setAuthenticatedLogin(loginField.getText());
            Authentication.setAuthenticatedPw(pwField.getText());
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/mainview.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setResizable(true);
            stage.setMinWidth(600);
            stage.setScene(new Scene(root));
            stage.centerOnScreen();
        } else {
            WrongCredentialsText.setVisible(true);
            FadeTransition ft = new FadeTransition();
            ft.setNode(WrongCredentialsText);
            ft.setDuration(new Duration(500));
            ft.setFromValue(1.0);
            ft.setToValue(0.0);
            ft.setCycleCount(666);
            ft.setAutoReverse(true);
            ft.play();

        }
    }
}

