package org.example.colorpickerej2;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.text.Font;

public class HelloController {

    @FXML
    private ComboBox<Integer> comboBox;

    @FXML
    private ColorPicker colorFondo;

    @FXML
    private ColorPicker colorTexto;

    @FXML
    private Label texto;

    @FXML
    public void initialize() {
        for (int i = 10; i<= 70; i++) {
            comboBox.getItems().add(i);
        }
    }

    @FXML
    protected void cambiarTamaño() {
        int t = Integer.parseInt(comboBox.getValue().toString());
        texto.setFont(new Font(t));
    }

    @FXML
    protected void cambiarFondo() {
        texto.setBackground(new Background(new BackgroundFill(colorFondo.getValue(), null, null)));
    }

    @FXML
    protected void cambiarTexto() {
        texto.setTextFill(colorTexto.getValue());
     }
}