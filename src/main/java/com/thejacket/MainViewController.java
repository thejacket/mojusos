package com.thejacket;

import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sun.plugin.javascript.navig.Anchor;

import java.io.IOException;

/**
 * Created by mariusz on 2017-04-20.
 */
public class MainViewController {


    @FXML
    private TextField textField;

    @FXML
    private Button signOutButton;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private SplitPane studenciAnchorPane;

    @FXML
    private TabPane tabPane;

    //@FXML
    //private ProtokolyController protokolyController;


    @FXML
    void initialize() {
        /*
        anchorPane.setTopAnchor(studenciAnchorPane,0.0);
        anchorPane.setBottomAnchor(studenciAnchorPane,0.0);
        anchorPane.setLeftAnchor(studenciAnchorPane,0.0);
        anchorPane.setRightAnchor(studenciAnchorPane, 0.0); nie działa!!! */
        System.out.println("one");

    }

    @FXML
        void signOut(ActionEvent event) throws IOException {

        Parent root;
        root = FXMLLoader.load(getClass().getResource("/signinview.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));

        }

    }

