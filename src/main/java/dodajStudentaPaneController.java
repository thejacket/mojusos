import com.thejacket.Student;
import com.thejacket.studenciController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Created by mariusz on 2017-05-11.
 */
public class dodajStudentaPaneController {
    @FXML
    TextField imieField;
    @FXML
    TextField nazwiskoField;
    @FXML
    TextField kierunekField;
    @FXML
    TextField peselField;
    @FXML
    TextField telefonField;
    @FXML
    TextField mailField;

    @FXML
    Button dodajDoDbButton;

    //@FXML
    //TableView                         --- how to get member of another controller? (studencicontroller)

    @FXML
    void initialize(){
        dodajDoDbButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
               new Student(peselField.getText(), telefonField.getText(), imieField.getText(), nazwiskoField.getText(), kierunekField.getText(), mailField.getText());
            }
        });
    }

}
