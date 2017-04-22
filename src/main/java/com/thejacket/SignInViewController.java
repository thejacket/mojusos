package com.thejacket;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

/**
 * Created by mariusz on 2017-04-20.
 */
public class SignInViewController {

        @FXML
        private PasswordField loginField;
        private PasswordField pwField;
        private Button signInButton;

        private String loginArg;
        private String pwArg;
        @FXML
        void signIn(ActionEvent event) {
            if (loginField.getText().equals(loginArg) && pwField.getText().equals(pwArg)) {
                //to i tamto
            }
            else {
                //co innego
            }
        }

    }

}
