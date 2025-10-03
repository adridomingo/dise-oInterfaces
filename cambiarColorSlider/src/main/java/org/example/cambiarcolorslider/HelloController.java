package org.example.cambiarcolorslider;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;

public class HelloController {

    @FXML
    private Slider rojo;

    @FXML
    private Slider verde;

    @FXML
    private Slider azul;

    @FXML
    private TextField fondo;

    @FXML
    private void initialize() {
        rojo.setMax(255);
        azul.setMax(255);
        verde.setMax(255);
    }

    @FXML
    private void cambiarColor() {
        fondo.setBackground(Background.fill(Color.rgb((int) rojo.getValue(), (int) verde.getValue(), (int) azul.getValue())));
    }
}