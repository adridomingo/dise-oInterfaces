package org.example.imagenes;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HelloController {

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private ImageView imagen;

    @FXML
    public void initialize() {
        comboBox.getItems().add("Perro");
        comboBox.getItems().add("Gato");
    }

    @FXML
    protected void cambiarImg() {
        if (comboBox.getValue().equals("Perro")) {
            Image img = new Image(getClass().getResource("img/perro.jpg").toExternalForm());
            imagen.setImage(img);
        } else {
            Image img = new Image(getClass().getResource("img/gato.jpg").toExternalForm());
            imagen.setImage(img);
        }
    }
}