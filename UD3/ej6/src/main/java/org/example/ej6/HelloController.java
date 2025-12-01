package org.example.ej6;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

public class HelloController {
    @FXML
    MenuItem estilos1;
    @FXML
    MenuItem estilos2;
    @FXML
    MenuItem quitar;

    @FXML
    Button btn;

    @FXML
    Label etiqueta;

    @FXML
    AnchorPane panel;

    @FXML
    public void estilos1() {
        panel.getStylesheets().clear();
        panel.getStylesheets().add(getClass().getResource("estilo1.css").toExternalForm());
    }

    @FXML
    public void estilos2() {
        panel.getStylesheets().clear();
        panel.getStylesheets().add(getClass().getResource("estilo2.css").toExternalForm());
    }

    @FXML
    public void quitarEstilos() {
        panel.getStylesheets().clear();
    }
}