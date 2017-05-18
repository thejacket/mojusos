package com.thejacket;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mariusz on 2017-05-17.
 */
public class przedmiotyController {

    ArrayList<Button> ButtonList = new ArrayList<Button>();

    @FXML
    ButtonBar przedmiotyButtonBar;

    @FXML
    HBox buttonshbox;

    @FXML
    SplitPane splitPane;

    @FXML
    AnchorPane dodajPrzedmiotPane;

    @FXML
    TableView przedmiotyTableView;

    @FXML
    TableColumn<Przedmiot, Number> idTableColumn;

    @FXML
    TableColumn<Przedmiot, String> nazwaTableColumn;

    @FXML
    TableColumn<Przedmiot, String> typTableColumn;

    @FXML
    TableColumn<Przedmiot, String> prowadzacyTableColumn;

    @FXML
    TableColumn<Przedmiot, Number> wymiarGodzinTableColumn;

    @FXML
    TableColumn<Przedmiot, Number> ectsTableColumn;

    @FXML
    TableColumn<Przedmiot, String> wydzialTableColumn;

    @FXML
    TableColumn<Przedmiot, ProgramStudiow> programTableColumn;



    @FXML
    void initialize() {

        przedmiotyTableViewInitialize();
        splitPane.setDividerPosition(0, 0.8);
        buttonsInitialize();
        buttonshbox.getChildren().addAll(ButtonList);
    }

    void przedmiotyTableViewInitialize(){
        idTableColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        nazwaTableColumn.setCellValueFactory(cellData -> cellData.getValue().nazwaProperty());
        typTableColumn.setCellValueFactory(cellData -> cellData.getValue().typProperty());
        prowadzacyTableColumn.setCellValueFactory(cellData -> cellData.getValue().prowadzacyProperty());
        ectsTableColumn.setCellValueFactory(cellData -> cellData.getValue().ectsProperty());
        wymiarGodzinTableColumn.setCellValueFactory(cellData -> cellData.getValue().wymiarGodzinProperty());
        wydzialTableColumn.setCellValueFactory(cellData -> cellData.getValue().wydzialProperty());
        //programTableColumn.setCellValueFactory(cellData -> cellData.getValue().ProgramStudiowStringProperty());

        przedmiotyTableView.getItems().addAll(DataHolder.getPrzedmiotObjectsList());
    }

    void buttonsInitialize() {
        Button odswiezButton = new Button("Odswiez tabelę");
        Button dodajPrzedmiotButton = new Button("Dodaj przedmiot");
        Button usuńPrzedmiotButton = new Button("Usuń przedmiot");

        odswiezButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                refreshprzedmiotyTableView();
            }
        });

        dodajPrzedmiotButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                dodajPrzedmiotPaneInitialize();
            }
        });

        usuńPrzedmiotButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                usuńPrzedmiot();
            }
        });


        ButtonList.add(odswiezButton);
        ButtonList.add(dodajPrzedmiotButton);
        ButtonList.add(usuńPrzedmiotButton);
    }


    void refreshprzedmiotyTableView(){
        przedmiotyTableView.getItems().clear();                       // workaround, need sth more efficient
        List<Przedmiot> ls = DataHolder.getPrzedmiotObjectsList();
        if (ls != null) {
            przedmiotyTableView.getItems().addAll(ls);
        }
        przedmiotyTableView.refresh();
    }

    void dodajPrzedmiotPaneInitialize(){
        dodajPrzedmiotPane.setVisible(true);
        splitPane.setDividerPosition(0, 0.18);   // should be calculated with regards to stage position
    }

    void usuńPrzedmiot(){
        Przedmiot p = (Przedmiot) przedmiotyTableView.getSelectionModel().getSelectedItem();
        if (p != null) {
            DataHolder.removeFromDb(p, p.getId());
            refreshprzedmiotyTableView();
            dodajPrzedmiotPane.setVisible(false);
        }
    }




}
