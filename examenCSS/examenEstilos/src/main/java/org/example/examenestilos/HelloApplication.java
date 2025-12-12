package org.example.examenestilos;

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
        Scene scene = new Scene(fxmlLoader.load(), 750, 450);
        stage.setTitle("Aprendemos Juntos!");
        stage.setScene(scene);
        stage.getIcons().add(new Image("icono.png"));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}