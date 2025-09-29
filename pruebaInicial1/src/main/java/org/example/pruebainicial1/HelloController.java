package org.example.pruebainicial1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class HelloController {

    // Ej1
    @FXML
    private TextField texto;

    @FXML
    private Button agregar;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private void agregarPelicula() {
        comboBox.getItems().add(texto.getText());
        texto.clear();
    }

    // EJ2
    @FXML
    private Text etiqueta;

    @FXML
    private Button saludar;

    @FXML
    private Button noSaludar;

    @FXML
    private void initialize() {
        etiqueta.setVisible(false);
    }

    @FXML
    private void mostrar() {
        etiqueta.setVisible(true);
    }

    @FXML
    private void ocultar() {
        etiqueta.setVisible(false);
    }
}