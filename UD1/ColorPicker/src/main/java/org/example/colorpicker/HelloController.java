package org.example.colorpicker;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.text.Text;

public class HelloController {
    @FXML
    private ColorPicker colorFondo;

    @FXML
    private ColorPicker colorTexto;

    @FXML
    private TextField textoFondo;

    @FXML
    private Text textoCambiar;

    @FXML
    private Button btn;

    @FXML
    protected void cambiarColor() {
        textoFondo.setBackground(new Background(new BackgroundFill(colorFondo.getValue(), null, null)));
        btn.setBackground(new Background(new BackgroundFill(colorFondo.getValue(), null, null)));
    }

    @FXML
    protected void cambiarColorTexto() {
        textoCambiar.setFill(colorTexto.getValue());
        btn.setTextFill(colorTexto.getValue());
    }
}