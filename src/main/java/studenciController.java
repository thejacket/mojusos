import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.util.ArrayList;

/**
 * Created by mariusz on 2017-05-10.
 */
public class studenciController {

    ArrayList<Button> ButtonList = new ArrayList<Button>();

    @FXML
    ButtonBar studenciButtonBar;

    @FXML
    HBox buttonshbox;

    @FXML
    SplitPane splitPane;

    @FXML
    AnchorPane dodajStudentaPane;

    @FXML
    void initialize() {

        buttonsInitialize();
        buttonshbox.getChildren().addAll(ButtonList);
    }

    void buttonsInitialize(){
        Button dodajStudentaButton = new Button("Dodaj studenta");
        Button usuńStudentaButton = new Button("Usuń studenta");
        final Button wyslijMailDoStudentaButton = new Button("Wyslij mail do studenta");

        dodajStudentaButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                dodajStudentaPaneInitialize();
            }
        });

        usuńStudentaButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                usuńStudenta();
            }
        });

        wyslijMailDoStudentaButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                wyslijMailDoStudenta();
            }
        });

        ButtonList.add(dodajStudentaButton);
        ButtonList.add(usuńStudentaButton);
        ButtonList.add(wyslijMailDoStudentaButton);
    }

    void dodajStudentaPaneInitialize(){
        dodajStudentaPane.setVisible(true);
        //dodajStudentaPane.getParent().getParent().getParent().getParent().getParent().setDivider() -- dlaczego nie znajduje ???? nielogiczne
        splitPane.setDividerPosition(0, 0.3);   // should be calculated with regards to stage position
    }

    void usuńStudenta(){
        dodajStudentaPane.setVisible(false);
    }

    void wyslijMailDoStudenta(){

    }
}
