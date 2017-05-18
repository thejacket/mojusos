package com.thejacket;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Created by mariusz on 2017-05-11.
 */
public class dodajPrzedmiotPaneController {

    @FXML
    TextField nazwaField;
    @FXML
    TextField typField;
    @FXML
    TextField prowadzacyField;
    @FXML
    TextField wymiarGodzinField;
    @FXML
    TextField ectsField;
    @FXML
    TextField wydzialField;
    @FXML
    TextField programField;

    @FXML
    Button dodajDoDbButton;

    //@FXML
    //TableView                         --- how to get member of another controller? (studencicontroller)

    @FXML
    void initialize(){

        dodajDoDbButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
               new Przedmiot(nazwaField.getText(), typField.getText(), prowadzacyField.getText(), Integer.parseInt(wymiarGodzinField.getText()), Integer.parseInt(ectsField.getText()), wydzialField.getText());
            }
        });
    }

}
