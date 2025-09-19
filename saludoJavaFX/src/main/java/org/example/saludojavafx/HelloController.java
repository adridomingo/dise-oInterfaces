package org.example.saludojavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField saludo;

    @FXML
    private Button boton1;

    @FXML
    private TextField texto;

    @FXML
    protected void onHelloButtonClick() {
        saludo.setText("Hola " + texto.getText());
    }
}