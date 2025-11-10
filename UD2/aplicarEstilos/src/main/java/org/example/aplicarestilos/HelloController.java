package org.example.aplicarestilos;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class HelloController {
    @FXML
    Button btn1;
    @FXML
    Button btn2;
    @FXML
    Button btn3;

    @FXML
    Button resetear;
    @FXML
    Button salir;

    @FXML
    AnchorPane panel;

    @FXML
    public void initialize() {
        btn1.setOnAction( e ->{
            panel.getStylesheets().add(getClass().getResource("estilos1.css").toExternalForm());
        });

        btn2.setOnAction( e ->{
            panel.getStylesheets().add(getClass().getResource("estilos2.css").toExternalForm());
        });

        btn3.setOnAction( e ->{
            panel.getStylesheets().add(getClass().getResource("estilos3.css").toExternalForm());
        });

        resetear.setOnAction(e -> {
            panel.getStylesheets().clear();
        });

        salir.setOnAction(e -> {

        });
    }

}