package com.thejacket;

import com.google.common.eventbus.EventBus;
import com.thejacket.DataHolder;
import com.thejacket.Student;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
    TableView studenciTableView;

    @FXML
    TableColumn<Student, Number> idTableColumn;

    @FXML
    TableColumn<Student, String> imieTableColumn;

    @FXML
    TableColumn<Student, String> nazwiskoTableColumn;

    @FXML
    TableColumn<Student, String> kierunekTableColumn;

    @FXML
    TableColumn<Student, String> peselTableColumn;

    @FXML
    TableColumn<Student, String> telefonTableColumn;

    @FXML
    TableColumn<Student, String> mailTableColumn;

    @FXML
    void initialize() {

        studenciTableViewInitialize();
        splitPane.setDividerPosition(0, 0.8);

        buttonsInitialize();
        buttonshbox.getChildren().addAll(ButtonList);
    }

    void studenciTableViewInitialize(){
        idTableColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        imieTableColumn.setCellValueFactory(cellData -> cellData.getValue().imieProperty());
        nazwiskoTableColumn.setCellValueFactory(cellData -> cellData.getValue().nazwiskoProperty());
        kierunekTableColumn.setCellValueFactory(cellData -> cellData.getValue().kierunekProperty());
        peselTableColumn.setCellValueFactory(cellData -> cellData.getValue().peselProperty());
        telefonTableColumn.setCellValueFactory(cellData -> cellData.getValue().telefonProperty());
        mailTableColumn.setCellValueFactory(cellData -> cellData.getValue().mailProperty());

        studenciTableView.getItems().addAll(DataHolder.getStudentObjectsList());
    }

    void buttonsInitialize(){
        Button odswiezButton = new Button("Odswiez tabelę");
        Button dodajStudentaButton = new Button("Dodaj studenta");
        Button usuńStudentaButton = new Button("Usuń studenta");
        final Button wyslijMailDoStudentaButton = new Button("Wyslij mail do studenta");

        odswiezButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                refreshstudenciTableView();
            }
        });

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


        ButtonList.add(odswiezButton);
        ButtonList.add(dodajStudentaButton);
        ButtonList.add(usuńStudentaButton);
        ButtonList.add(wyslijMailDoStudentaButton);
}

    void refreshstudenciTableView(){
        studenciTableView.getItems().clear();                       // workaround, need sth more efficient
        List<Student> ls = DataHolder.getStudentObjectsList();
        if (ls != null) {
            studenciTableView.getItems().addAll(ls);
        }
        studenciTableView.refresh();
    }

    void dodajStudentaPaneInitialize(){
        dodajStudentaPane.setVisible(true);
        //dodajStudentaPane.getParent().getParent().getParent().getParent().getParent().setDivider() -- dlaczego nie znajduje ???? nielogiczne
        splitPane.setDividerPosition(0, 0.3);   // should be calculated with regards to stage position
    }

    void usuńStudenta(){
        Student s = (Student) studenciTableView.getSelectionModel().getSelectedItem();
        if (s != null) {
            DataHolder.removeFromDb(s, s.getId());
            refreshstudenciTableView();
            dodajStudentaPane.setVisible(false);
        }
    }

    void wyslijMailDoStudenta(){

    }




}
