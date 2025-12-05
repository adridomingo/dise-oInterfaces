package org.example.ej2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 240);
        stage.setTitle("Calculadora IMC");
        stage.setScene(scene);
        stage.getIcons().add(new Image("App1.png"));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}