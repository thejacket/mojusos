package com.thejacket; /**
 * Hello world!
 *
 */
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root;
            //get reference to the button's stage
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("/signinview.fxml"));
            //create a new scene with root and set the stage
            Scene scene = new Scene(root);
            primaryStage.setResizable(false);
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.centerOnScreen();

            primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                public void handle(WindowEvent e) {
                    HibernateSession.getSessionFactory().close();               // sth not gud here
                    Platform.exit();
                    System.exit(0);
                }
            });

        } catch (Exception ex) {
        }
    }
}
