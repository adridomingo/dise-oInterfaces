package org.example.radiobuttons;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private RadioButton zaragoza;

    @FXML
    private RadioButton huesca;

    @FXML
    private RadioButton teruel;

    @FXML
    private TextField texto;

    @FXML
    protected void rellenarTexto() {
        if (zaragoza.isSelected()) {
            texto.setText("Zaragoza");
        } else if (huesca.isSelected()) {
            texto.setText("Huesca");
        } else if (teruel.isSelected()) {
            texto.setText("Teruel");
        }
    }
}