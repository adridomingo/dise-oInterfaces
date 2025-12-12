package org.example.examenestilos;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HelloController {
    @FXML
    AnchorPane panel;
    @FXML
    MenuItem estilo1;
    @FXML
    MenuItem estilo2;
    @FXML
    MenuItem eliminar;
    @FXML
    MenuItem documentacion;

    @FXML
    ToggleGroup atender;
    @FXML
    ToggleButton tbF;
    @FXML
    ToggleButton tbAm;
    @FXML
    ToggleButton tbPv;
    @FXML
    ToggleButton tbN;
    @FXML
    ToggleGroup habla;
    @FXML
    RadioButton rbF;
    @FXML
    RadioButton rbAm;
    @FXML
    RadioButton rbPv;
    @FXML
    RadioButton rbN;
    @FXML
    ProgressBar progressBar;
    @FXML
    ProgressIndicator progressIndicator;

    @FXML
    Slider slider;
    @FXML
    ImageView img;

    @FXML
    public void initialize(){
        // MENU BAR
        estilo1.setOnAction(e -> {
            panel.getStylesheets().clear();
            panel.getStylesheets().add(getClass().getResource("estilos1.css").toExternalForm());
        });
        estilo2.setOnAction(e -> {
            panel.getStylesheets().clear();
            panel.getStylesheets().add(getClass().getResource("estilos2.css").toExternalForm());
        });
        eliminar.setOnAction(e -> {
            panel.getStylesheets().clear();
        });
        documentacion.setOnAction(e -> {
            try {
                Desktop.getDesktop().browse(new URI("examenEstilos.chm"));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (URISyntaxException ex) {
                throw new RuntimeException(ex);
            }
        });

        // PROGRESS BBAR
        tbF.setOnAction(e -> {
            progressBar.setProgress(1);
        });
        tbAm.setOnAction(e -> {
            progressBar.setProgress(0.75);
        });
        tbPv.setOnAction(e -> {
            progressBar.setProgress(0.5);
        });
        tbN.setOnAction(e -> {
            progressBar.setProgress(0.25);
        });

        // PROGRESS INDICATOR
        rbF.setOnAction(e -> {
            progressIndicator.setProgress(1);
        });
        rbAm.setOnAction(e -> {
            progressIndicator.setProgress(0.75);
        });
        rbPv.setOnAction(e -> {
            progressIndicator.setProgress(0.5);
        });
        rbN.setOnAction(e -> {
            progressIndicator.setProgress(0.25);
        });

        // SLIDER
        slider.setMax(99);
        slider.setBlockIncrement(1.0);

    }

    @FXML
    public void cambiarImagen() {
        Double valor = slider.getValue();
        Image imagen;

        if (valor<=33) {
           imagen = new Image(getClass().getResource("img/nivel1.jpg").toExternalForm());
           img.setImage(imagen);
        } else if (valor<=66) {
            imagen = new Image(getClass().getResource("img/nivel2.jpg").toExternalForm());
            img.setImage(imagen);
        } else if (valor<=99) {
            imagen = new Image(getClass().getResource("img/nivel3.jpg").toExternalForm());
            img.setImage(imagen);
        }
    }


}