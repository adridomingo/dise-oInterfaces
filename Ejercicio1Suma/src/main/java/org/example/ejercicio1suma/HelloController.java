package org.example.ejercicio1suma;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    // TextFields
    @FXML
    private TextField numero1;

    @FXML
    private TextField numero2;

    @FXML
    private TextField resultado;

    // Botones
    @FXML
    private Button sumar;

    @FXML
    private Button restar;

    @FXML
    private Button multiplicar;

    // Funciones
    @FXML
    protected void sumar() {
        resultado.setText(Integer.toString(Integer.parseInt(numero1.getText()) + Integer.parseInt(numero2.getText())));
    }

    @FXML
    protected void restar() {
        resultado.setText(Integer.toString(Integer.parseInt(numero1.getText()) - Integer.parseInt(numero2.getText())));
    }

    @FXML
    protected void multiplicar() {
        resultado.setText(Integer.toString(Integer.parseInt(numero1.getText()) * Integer.parseInt(numero2.getText())));
    }
}