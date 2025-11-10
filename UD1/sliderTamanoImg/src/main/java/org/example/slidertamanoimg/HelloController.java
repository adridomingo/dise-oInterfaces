package org.example.slidertamanoimg;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HelloController {
    @FXML
    private ImageView imgPerro;

    @FXML
    private Slider slider;

    @FXML
    public void initialize() {
        slider.setMax(imgPerro.getFitWidth());
    }

    @FXML
    private void cambiarTamaño() {
        imgPerro.setFitHeight(slider.getValue());
        imgPerro.setFitWidth(slider.getValue());
    }
}