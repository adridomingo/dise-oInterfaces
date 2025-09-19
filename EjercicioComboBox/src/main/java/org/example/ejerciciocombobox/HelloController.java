package org.example.ejerciciocombobox;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private ComboBox<String> provincia;

    @FXML
    public void initialize() {
        provincia.getItems().addAll("Zaragoza", "Huesca", "Teruel");
        provincia.setPromptText("Zaragoza");
    }

    @FXML
    private ComboBox<String> instituto;

    @FXML
    private TextField texto;

    @FXML
    private Button confirmar;

    @FXML
    protected void rellenarTextoBoton() {
        texto.setText(provincia.getValue());
    }

    @FXML
    protected void rellenarTexto() {
        texto.setText(provincia.getValue());
        instituto.getItems().clear();

        if (provincia.getValue().equals("Zaragoza")) {
            instituto.getItems().addAll("Miguel Catalán", "Arcosur");
        } else if (provincia.getValue().equals("Huesca")) {
            instituto.getItems().addAll("Pirámide", "Salesas");
        } else if (provincia.getValue().equals("Teruel")) {
            instituto.getItems().addAll("Segundo de Chomón", "Vega del Turia");
        }
    }
}