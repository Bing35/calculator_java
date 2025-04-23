package it.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage1) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("calculator.fxml"));

        var scene = new Scene(root);
        stage1.setScene(scene);
        stage1.setTitle("calculator");
        stage1.show();
    }

    public static void main(String[] args) {
        launch();
    }

}