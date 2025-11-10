package org.example.tabpanel;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;

public class HelloController {
    @FXML
    CheckBox coche;

    @FXML
    CheckBox monovolumen;

    @FXML
    private Tab pestanaCoche;

    @FXML
    private Tab pestanaMonovolumen;

    @FXML
    private void initialize() {
        pestanaCoche.setDisable(true);
        pestanaMonovolumen.setDisable(true);
    }

    @FXML
    private void activarCoche() {
        pestanaCoche.setDisable(!coche.isSelected());
    }

    @FXML
    private void activarMonovolumen() {
        pestanaMonovolumen.setDisable(!monovolumen.isSelected());
    }
}