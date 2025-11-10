package org.example.cambiarfondogrid;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class HelloController {
    @FXML
    private ComboBox<Integer> rojo;

    @FXML
    private ComboBox<Integer> verde;

    @FXML
    private ComboBox<Integer> azul;

    @FXML
    private TextField fondo;

    @FXML
    private void initialize() {
        for (int i = 0; i<=255; i++) {
            rojo.getItems().add(i);
            verde.getItems().add(i);
            azul.getItems().add(i);
        }
        rojo.getSelectionModel().select(0);
        verde.getSelectionModel().select(0);
        azul.getSelectionModel().select(0);
    }

    @FXML
    private void cambiarColor() {
        if (rojo.getValue() == null || verde.getValue()==null || azul.getValue()==null) {
            return;
        }
        fondo.setBackground(Background.fill(Color.rgb(rojo.getValue(), verde.getValue(), azul.getValue())));
    }
}