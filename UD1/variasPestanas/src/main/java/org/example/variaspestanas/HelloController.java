package org.example.variaspestanas;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private TextField nombre;

    @FXML
    private TextField apellidos;

    @FXML
    private TextField fecha;

    @FXML
    private ImageView imageView;

    @FXML
    private TextArea consulta;

    @FXML
    private CheckBox terms;

    @FXML
    private Button enviar;

    @FXML
    public void startDNI() throws IOException {
        FXMLLoader fxmlLoader = new
                FXMLLoader(HelloApplication.class.getResource("DNI.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        Stage stage3 = new Stage();
        stage3.setTitle("Ventana DNI");
        stage3.setScene(scene);
        stage3.show();
    }

    @FXML
    public void startAyuda() throws IOException {
        FXMLLoader fxmlLoader = new
                FXMLLoader(HelloApplication.class.getResource("Ayuda.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage2 = new Stage();
        stage2.setTitle("Ventana Ayuda 2");
        stage2.setScene(scene);
        stage2.show();
    }


}