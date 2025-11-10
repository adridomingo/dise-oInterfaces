package org.example.eventhandler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class HelloController {
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Text txt;

    @FXML
    public void initialize() {
        btn1.setOnAction(e -> txt.setText("Hola"));
        btn2.setOnAction(e -> txt.setText("Adios"));
    }
}